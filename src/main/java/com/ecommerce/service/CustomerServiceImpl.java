package com.ecommerce.service;

import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.exception.ECartException;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerDTO authenticateCustomer(String emailId, String password) throws ECartException {
        CustomerDTO customerDTO = null;
        Optional<Customer> optionalCustomer = customerRepository.findById(emailId);
        Customer customer = optionalCustomer.orElseThrow(()-> new ECartException("Customer.Service.CUSTOMER_NOT_FOUND"));
        if(!password.equals(customer.getPassword())){
            throw new ECartException("Customer.Service.INVALID_CREDENTIALS");
        }
        customerDTO = new CustomerDTO();
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setName(customer.getName());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setNewPassword(customer.getPassword());
        customerDTO.setPassword(customer.getPassword());
        return customerDTO;
    }

    @Override
    public String registerNewCustomer(CustomerDTO customerDTO) throws ECartException {
        return null;
    }

    @Override
    public void updateShippingAddress(String emailId, String address) throws ECartException {

    }

    @Override
    public void deleteShippingAddress(String emailId) throws ECartException {

    }

    @Override
    public CustomerDTO getCustomerByEmailId(String emailId) throws ECartException {
        return null;
    }
}
