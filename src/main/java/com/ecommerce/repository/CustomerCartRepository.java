package com.ecommerce.repository;

import com.ecommerce.entity.CustomerCart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerCartRepository extends CrudRepository<CustomerCart,Integer> {
    Optional<CustomerCart> findByCustomerEmailId(String emailId);
}
