package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CustomerCartDTO {
    private Integer cartId;
    private String customerEmailId;
    private Set<CartProductDTO> cartProducts;
}
