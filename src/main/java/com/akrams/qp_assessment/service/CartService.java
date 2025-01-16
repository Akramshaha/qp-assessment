package com.akrams.qp_assessment.service;

import com.akrams.qp_assessment.dto.AddToCartDto;
import com.akrams.qp_assessment.dto.CartCost;
import com.akrams.qp_assessment.model.Cart;
import com.akrams.qp_assessment.model.Grocery;

public interface CartService {

    void addToCart(AddToCartDto addToCartDto, int userId);
    CartCost listCartItems(int user_id);

    void updateCartItem(AddToCartDto cartDto, int userId, Grocery grocery);
    void deleteCartItem(Integer id);
}
