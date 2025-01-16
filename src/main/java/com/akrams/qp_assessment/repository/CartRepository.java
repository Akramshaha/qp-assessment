package com.akrams.qp_assessment.repository;

import com.akrams.qp_assessment.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserIdOrderByCreatedDateDesc(Integer userId);
    Cart findByGroceryIdAndUserId(Integer groceryId, Integer userId);
    void deleteAllByGroceryId(Integer groceryId);
}
