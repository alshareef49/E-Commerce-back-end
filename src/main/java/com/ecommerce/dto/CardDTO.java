package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CardDTO {
    private String cardType;
    private String cardNumber;
    private String nameOnCard;
    private String hashCvv;
    private Integer cvv;
    private LocalDate expiryDate;
    private Integer cardId;
    private String customerEmailId;
}
