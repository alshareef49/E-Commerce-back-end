package com.ecommerce.repository;

import com.ecommerce.entity.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card,Integer> {
    List<Card> findByCustomerEmailId(String customerEmailId);
    List<Card> findByCustomerEmailIdAndCardType(String customerEmailId,String cardType);
}
