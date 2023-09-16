package com.ecommerce.service;

import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.exception.ECartException;

public interface CustomerService {
    CustomerDTO authenticateCustomer(String emailId,String password) throws ECartException;
    String registerNewCustomer(CustomerDTO customerDTO) throws ECartException;
    void updateShippingAddress(String emailId,String address) throws ECartException;
    void deleteShippingAddress(String emailId) throws ECartException;
    CustomerDTO getCustomerByEmailId(String emailId) throws ECartException;
}
