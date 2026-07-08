package com.example.management_library_system.service;

import com.example.management_library_system.dto.LoanRequestDTO;
import com.example.management_library_system.dto.LoanResponseDTO;
import com.example.management_library_system.model.*;
import com.example.management_library_system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanCardRepository loanCardRepository;
    @Autowired
    private LoanDetailRepository loanDetailRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void createLoan(String userEmail, LoanRequestDTO request) {
        Account borrower = accountRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản người dùng!"));

        LoanCard card = new LoanCard();
        card.setCreateDate(LocalDate.now());
        card.setBorrower(borrower);
        card = loanCardRepository.save(card);

        LocalDate dueDate = LocalDate.parse(request.getExpectedReturnDate());

        for (Integer bookId : request.getBookIds()) {
            Book book = bookRepository.findById(bookId).orElse(null);
            if (book != null) {
                // Kiểm tra nhanh: Nếu lúc đặt mượn đã hết sách thì chặn luôn
                if (book.getQuantity() <= 0) {
                    throw new RuntimeException("Sách '" + book.getBookName() + "' đã hết số lượng, không thể mượn!");
                }
                
                LoanDetail detail = new LoanDetail();
                detail.setLoanCard(card);
                detail.setBook(book);
                detail.setBorrowDate(LocalDate.now());
                detail.setDueDate(dueDate);
                detail.setStatus("Chờ Duyệt"); 
                loanDetailRepository.save(detail);
            }
        }
    }

    public List<LoanResponseDTO> getMyLoans(String userEmail) {
        Account borrower = accountRepository.findByEmail(userEmail).orElseThrow();
        List<LoanDetail> details = loanDetailRepository.findByLoanCardBorrower(borrower);
        return details.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<LoanResponseDTO> getAllLoans() {
        List<LoanDetail> details = loanDetailRepository.findAll();
        return details.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // LOGIC CẬP NHẬT SỐ LƯỢNG KHI DUYỆT / TRẢ SÁCH
    @Transactional
    public void updateLoanStatus(Integer detailId, String newStatus) {
        LoanDetail detail = loanDetailRepository.findById(detailId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết phiếu mượn!"));
        
        String oldStatus = detail.getStatus();
        Book book = detail.getBook();

        // 1. Nếu Admin duyệt "Đang Mượn" -> Trừ kho, Tăng lượt mượn
        if (newStatus.equals("Đang Mượn") && oldStatus.equals("Chờ Duyệt")) {
            if (book.getQuantity() <= 0) {
                throw new RuntimeException("Sách '" + book.getBookName() + "' hiện đã hết trong kho, không thể duyệt!");
            }
            book.setQuantity(book.getQuantity() - 1);
            book.setBorrowCount(book.getBorrowCount() + 1);
            bookRepository.save(book);
        } 
        // 2. Nếu Admin duyệt "Đã Trả" -> Cộng lại kho
        else if (newStatus.equals("Đã Trả") && oldStatus.equals("Đang Mượn")) {
            detail.setReturnDate(LocalDate.now());
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
        }
        // Lưu ý: Nếu Admin chọn "Từ Chối", kho sách không bị trừ nên không cần cộng lại.

        detail.setStatus(newStatus);
        loanDetailRepository.save(detail);
    }

    private LoanResponseDTO convertToDTO(LoanDetail detail) {
        LoanResponseDTO dto = new LoanResponseDTO();
        dto.setDetailID(detail.getDetailID());
        dto.setBorrowDate(detail.getBorrowDate() != null ? detail.getBorrowDate().toString() : "");
        dto.setDueDate(detail.getDueDate() != null ? detail.getDueDate().toString() : "");
        dto.setStatus(detail.getStatus());

        if (detail.getLoanCard() != null) {
            LoanResponseDTO.LoanCardInfo cardInfo = new LoanResponseDTO.LoanCardInfo();
            cardInfo.setCardID(detail.getLoanCard().getCardID());
            if (detail.getLoanCard().getBorrower() != null) {
                LoanResponseDTO.BorrowerInfo borrowerInfo = new LoanResponseDTO.BorrowerInfo();
                borrowerInfo.setFullName(detail.getLoanCard().getBorrower().getFullName()); 
                Account acc = detail.getLoanCard().getBorrower();
                
                borrowerInfo.setFullName(acc.getFullName()); 
                borrowerInfo.setEmail(acc.getEmail());
                cardInfo.setBorrower(borrowerInfo);
            }
            dto.setLoanCard(cardInfo);
        }

        if (detail.getBook() != null) {
            LoanResponseDTO.BookInfo bookInfo = new LoanResponseDTO.BookInfo();
            bookInfo.setBookID(detail.getBook().getBookID());
            bookInfo.setBookName(detail.getBook().getBookName());
            bookInfo.setPublisher(detail.getBook().getPublisher());
            bookInfo.setYearPublish(detail.getBook().getYearPublish());
            dto.setBook(bookInfo);
        }
        return dto;
    }
}