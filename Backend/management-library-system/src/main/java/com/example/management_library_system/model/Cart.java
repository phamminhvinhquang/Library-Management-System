package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "Cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartID;

    // Mỗi tài khoản độc giả sẽ có một giỏ sách duy nhất (Mối quan hệ 1-1)
    @OneToOne
    @JoinColumn(name = "accountID")
    private Account account;

    // Một giỏ sách chứa nhiều sản phẩm/sách bên trong
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems;
}