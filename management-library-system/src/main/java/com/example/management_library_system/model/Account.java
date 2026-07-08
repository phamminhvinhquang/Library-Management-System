package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
// Thêm thư viện JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnore; 

@Entity
@Table(name = "Account") // Dùng chung cho tất cả
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;

    @Column(length = 50, unique = true)
    private String fullName; // Gộp chung cho username / staffName

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 255)
    private String password;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String address;

    @Column(length = 20)
    private String role; 

    // THÊM @JsonIgnore VÀO CÁC TRƯỜNG BÊN DƯỚI
    @JsonIgnore
    @OneToMany(mappedBy = "borrower")
    private List<LoanCard> borrowedCards;

    @JsonIgnore
    @OneToMany(mappedBy = "staffInCharge")
    private List<LoanCard> processedCards;

    @JsonIgnore
    @OneToOne(mappedBy = "account")
    private Cart cart;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Fine> fines;
}