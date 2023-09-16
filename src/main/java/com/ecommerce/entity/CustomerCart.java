package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "EK_CUSTOMER_CART")
public class CustomerCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @Column(name = "CUSTOMER_EMAIL_ID")
    private String customerEmailId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private Set<CartProduct> cartProducts;
}
