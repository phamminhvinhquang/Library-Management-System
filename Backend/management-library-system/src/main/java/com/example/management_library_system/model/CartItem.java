package com.example.management_library_system.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cart_Item")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartItemID;

    // Thuộc về giỏ sách nào
    @ManyToOne
    @JoinColumn(name = "cartID")
    private Cart cart;

    // Liên kết tới cuốn sách được chọn
    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;

    // Số lượng của đầu sách này trong giỏ
    private Integer quantity;
}