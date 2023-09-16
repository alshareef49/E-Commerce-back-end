package com.ecommerce.repository;

import com.ecommerce.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerOrderRepository extends CrudRepository<Order,Integer> {
    List<Order> findByCustomerEmailId(String emailId);
}
