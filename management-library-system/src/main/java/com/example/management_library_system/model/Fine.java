package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Fine")
@Data
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fineID;

    // Số tiền phạt phát sinh
    private Double fineAmount; 

    // Lý do bị phạt (ví dụ: "Trả trễ hạn 5 ngày", "Làm rách trang sách",...)
    @Column(columnDefinition = "TEXT")
    private String reason; 

    // Ngày ghi nhận quyết định phạt
    private LocalDate fineDate; 

    // Trạng thái thanh toán: "UNPAID" (Chưa nộp), "PAID" (Đã nộp)
    @Column(length = 30)
    private String status; 

    // Phạt dựa trên lượt mượn trả chi tiết nào
    @ManyToOne
    @JoinColumn(name = "detailID")
    private LoanDetail loanDetail;

    // Ai là người phải nộp khoản phạt này
    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account;
}