package com.ecommerce.entity;

import com.ecommerce.dto.OrderStatus;
import com.ecommerce.dto.PaymentThrough;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "EK_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String customerEmailId;
    private LocalDate dateOfOrder;
    private Double discount;
    private Double totalPrice;
    @Enumerated(EnumType.STRING)
    private PaymentThrough paymentThrough;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDateTime dateOfDelivery;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private List<OrderedProduct> orderedProducts;
    private String deliveryAddress;
}
