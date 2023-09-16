package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private String orderId;
    private String customerEmailId;
    private LocalDate dateOfOrder;
    private Double totalPrice;
    private String orderStatus;
    private Double discount;
    private String paymentThrough;
    private LocalDate dateOfDelivery;
    private String deliveryAddress;
    private List<OrderedProductDTO> orderedProductsDTO;
}
