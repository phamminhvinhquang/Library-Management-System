package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Loan_Detail")
@Data
public class LoanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailID;

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    @Column(length = 30)
    private String status;

    // Liên kết khóa ngoại tới Thẻ mượn (Loan_Card)
    @ManyToOne
    @JoinColumn(name = "cardID")
    private LoanCard loanCard;

    // Liên kết khóa ngoại tới Sách (Book)
    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;

    @OneToMany(mappedBy = "loanDetail")
    private List<Fine> fines;
}