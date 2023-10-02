package com.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private String emailId;
    private String name;
    private String password;
    private String newPassword;
    private String phoneNumber;
    private String address;
}
