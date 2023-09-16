package com.ecommerce.api;

import com.ecommerce.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@RequestMapping(value = "/customer-api")
public class CustomerAPI {
    private CustomerService customerService;

}
