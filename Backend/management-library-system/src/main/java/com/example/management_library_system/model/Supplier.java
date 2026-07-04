package com.example.managementlibrarysystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="supplier_name")
    private String supplierName;

    private String phone;

    private String email;

    private String address;

    @OneToMany(mappedBy = "supplier")
    private List<Book> books = new ArrayList<>();

}
