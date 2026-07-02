package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "Account") // Dùng chung cho tất cả
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;

    @Column(length = 50)
    private String fullName; // Gộp chung cho username / staffName

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 255)
    private String password;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String address;

    // CỘT QUAN TRỌNG NHẤT ĐỂ PHÂN QUYỀN
    // Các giá trị có thể là: "ROLE_USER", "ROLE_STAFF", "ROLE_ADMIN"
    @Column(length = 20)
    private String role; 

    // Các thẻ mượn do người này (với vai trò Độc giả) mượn
    @OneToMany(mappedBy = "borrower")
    private List<LoanCard> borrowedCards;

    // Các thẻ mượn do người này (với vai trò Nhân viên) duyệt/tạo
    @OneToMany(mappedBy = "staffInCharge")
    private List<LoanCard> processedCards;

    //để tra cứu giỏ hàng hoặc lịch sử phạt
    @OneToOne(mappedBy = "account")
    private Cart cart;

    @OneToMany(mappedBy = "account")
    private List<Fine> fines;
}