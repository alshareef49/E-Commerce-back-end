package com.ecommerce.service;

import com.ecommerce.dto.CustomerDTO;
import com.ecommerce.entity.Customer;
import com.ecommerce.exception.ECartException;
import com.ecommerce.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
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
        String registerWithEmailId  = null;
        boolean isEmailNotAvailable = customerRepository.findById(customerDTO.getEmailId().toLowerCase()).isEmpty();
        boolean isPhoneNumberNotAvailable = customerRepository.findByPhoneNumber(customerDTO.getPhoneNumber()).isEmpty();
        if(isEmailNotAvailable){
            if(isPhoneNumberNotAvailable){
                Customer customer = new Customer();
                customer.setAddress(customerDTO.getAddress());
                customer.setName(customerDTO.getName());
                customer.setPassword(customerDTO.getPassword());
                customer.setEmailId(customerDTO.getEmailId());
                customer.setPhoneNumber(customerDTO.getPhoneNumber());
                customerRepository.save(customer);
                registerWithEmailId = customer.getEmailId();
            }else {
                throw new ECartException("CustomerService.PHONE_NUMBER_ALREADY_IN_USE");
            }
        }else {
            throw new ECartException("CustomerService.EMAIL_ID_ALREADY_IN_USE");
        }
        return registerWithEmailId;
    }

    @Override
    public void updateShippingAddress(String emailId, String address) throws ECartException {
        Optional<Customer> optionalCustomer = customerRepository.findById(emailId.toLowerCase());
        Customer customer = optionalCustomer.orElseThrow(()-> new ECartException("CustomerService.CUSTOMER_NOT_FOUND"));
        customer.setAddress(address);
    }

    @Override
    public void deleteShippingAddress(String emailId) throws ECartException {
        Optional<Customer> optionalCustomer = customerRepository.findById(emailId.toLowerCase());
        Customer customer = optionalCustomer.orElseThrow(()-> new ECartException("CustomerService.CUSTOMER_NOT_FOUND"));
        customer.setAddress(null);
    }

    @Override
    public CustomerDTO getCustomerByEmailId(String emailId) throws ECartException {
        Optional<Customer> optionalCustomer = customerRepository.findById(emailId.toLowerCase());
        Customer customer = optionalCustomer.orElseThrow(()->new ECartException("CustomerService.CUSTOMER_NOT_FOUND"));
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setNewPassword(customer.getPassword());
        return customerDTO;
    }
}
