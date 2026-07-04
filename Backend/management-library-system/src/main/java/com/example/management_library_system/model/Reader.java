package com.example.managementlibrarysystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name")
    private String fullName;

    private String gender;

    private String phone;

    private String email;

    private String address;

    @OneToMany(mappedBy = "reader")
    private List<LoanCard> loanCards = new ArrayList<>();

}
