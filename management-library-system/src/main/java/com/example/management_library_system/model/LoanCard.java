package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Loan_Card")
@Data
public class LoanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardID;

    private LocalDate createDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Khóa ngoại trỏ đến Account (Người mượn sách)
    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Account borrower;

    // Khóa ngoại trỏ đến Account (Nhân viên tạo thẻ)
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Account staffInCharge;

    @OneToMany(mappedBy = "loanCard")
    private List<LoanDetail> loanDetails;
}