package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderedProductDTO {
    private Integer orderedProductId;
    private ProductDTO product;
    private Integer quantity;
}
