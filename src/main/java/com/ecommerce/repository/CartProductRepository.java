package com.ecommerce.repository;

import com.ecommerce.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;

public interface CartProductRepository extends CrudRepository<CartProduct,Integer> {
}
