package com.ecommerce.repository;

import com.ecommerce.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,String> {
    List<Customer> findByPhoneNumber(String phoneNumber);
}
