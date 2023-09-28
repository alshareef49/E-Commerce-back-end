package com.ecommerce.api;

import com.ecommerce.dto.CustomerCredDTO;
import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.exception.ECartException;
import com.ecommerce.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/customer-api")
public class CustomerAPI {
    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping(value = "/login")
    public ResponseEntity<CustomerDTO> authenticateCustomer(@RequestBody CustomerCredDTO customerCredDTO) throws ECartException {
        log.info("Customer Trying to login, Validating Credentials. Customer Email ID:{}", customerCredDTO.getEmailId());
        CustomerDTO customerDTOFromDb = customerService.authenticateCustomer(customerCredDTO.getEmailId(), customerCredDTO.getPassword());
        log.info("Customer login Success, Customer Email Id:{}",customerDTOFromDb.getEmailId());
        return new ResponseEntity<>(customerDTOFromDb, HttpStatus.OK);
    }

}
