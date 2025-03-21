package com.ecommerce.api;

import com.ecommerce.dto.CustomerCredDTO;
import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.exception.ECartException;
import com.ecommerce.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customerDTO) throws ECartException{
        log.info("Customer is Trying to register, Customer Email ID:{}",customerDTO.getEmailId());
        String registerEmailId = customerService.registerNewCustomer(customerDTO);
        log.info("Customer Successfully register with Email Id:{}",registerEmailId);
        String message = "Customer Successfully register with Email Id:"+registerEmailId;
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @PutMapping(value = "/customer/{emailId}/address/")
    public ResponseEntity<String> updateShippingAddress(@PathVariable String emailId,@RequestBody CustomerDTO customerDTO) throws ECartException{
        log.info("updating shipping address for Email Id:{}",emailId);
        customerService.updateShippingAddress(emailId,customerDTO.getAddress());
        String message = "Successfully updated shipping address for "+emailId;
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{emailId}")
    public ResponseEntity<String> deleteShippingAddress(@PathVariable String emailId) throws ECartException{
        log.info("Customer trying to delete shipping address, Email Id:{}",emailId);
        customerService.deleteShippingAddress(emailId);
        String message = "Customer successfully deleted shipping address email id:"+emailId;
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{emailId}")
    public ResponseEntity<CustomerDTO> getCustomerByEmailId(@PathVariable String emailId) throws ECartException{
        CustomerDTO customerDTO = customerService.getCustomerByEmailId(emailId);
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }

}
