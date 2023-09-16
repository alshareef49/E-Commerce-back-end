package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionDTO {
    private Integer transactionId;
    private OrderDTO order;
    private CardDTO card;
    private Double totalPrice;
    private LocalDate transactionDate;
    private TransactionStatus transactionStatus;
}
