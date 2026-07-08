package com.example.management_library_system.dto;

import lombok.Data;

@Data
public class LoanResponseDTO {
    private Integer detailID;
    private String borrowDate;
    private String dueDate;
    private String status;
    private LoanCardInfo loanCard;
    private BookInfo book;

    @Data
    public static class LoanCardInfo {
        private Integer cardID;
        private BorrowerInfo borrower;
    }

    @Data
    public static class BorrowerInfo {
        private String fullName;
        private String email;
        private String phone;
    }

    @Data
    public static class BookInfo {
        private Integer bookID;
        private String bookName;
        private String publisher;
        private Integer yearPublish;
    }
}