package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String productId;
    private String name;
    private String description;
    private String category;
    private String brand;
    private Double price;
    private Double discount;
    private Integer quantity;
    private String errorMessage;
    private String successMessage;
    private String sellerEmailId;
    private Integer availableQuantity;
}
