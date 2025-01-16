package com.akrams.qp_assessment.service.impl;

import com.akrams.qp_assessment.dto.AddToCartDto;
import com.akrams.qp_assessment.dto.CartCost;
import com.akrams.qp_assessment.dto.CartDto;
import com.akrams.qp_assessment.model.Cart;
import com.akrams.qp_assessment.model.Grocery;
import com.akrams.qp_assessment.repository.CartRepository;
import com.akrams.qp_assessment.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addToCart(AddToCartDto addToCartDto, int userId) {
        //check if the item with same user already exists
        Cart existCart = cartRepository.findByGroceryIdAndUserId(addToCartDto.getGroceryId(), userId);
        Cart cart = new Cart();
        if(existCart == null){
            cart = getAddToCartFromDto(addToCartDto,userId);
        }else{
            cart.setId(existCart.getId());
            cart.setGroceryId(addToCartDto.getGroceryId());
            cart.setQuantity(addToCartDto.getQuantity()+existCart.getQuantity());
            cart.setUserId(userId);
            cart.setCreatedDate(new Date());
        }
        cartRepository.save(cart);
    }

    public Cart getAddToCartFromDto(AddToCartDto addToCartDto, int userId) {
        Cart cart = new Cart();
        cart.setGroceryId(addToCartDto.getGroceryId());
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setUserId(userId);
        cart.setCreatedDate(new Date());
        return cart;
    }

    @Override
    public CartCost listCartItems(int user_id) {
        List<Cart> cartList = cartRepository.findAllByUserIdOrderByCreatedDateDesc(user_id);
        List<CartDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartDto cartDto = getDtoFromCart(cart);
            cartItems.add(cartDto);
        }
        double totalCost = 0;
        for (CartDto cartDto:cartItems){
            totalCost += (cartDto.getGrocery().getPrice()* cartDto.getQuantity());
        }
        CartCost cartCost = new CartCost(cartItems,totalCost);
        return cartCost;
    }

    public static CartDto getDtoFromCart(Cart cart) {
        CartDto cartDto = new CartDto(cart);
        return cartDto;
    }

    @Override
    public void updateCartItem(AddToCartDto cartDto, int userId, Grocery grocery) {
        Cart cart = getAddToCartFromDto(cartDto,userId);
        cart.setQuantity(cartDto.getQuantity());
        cart.setUserId(userId);
        cart.setId(cartDto.getId());
        cart.setGroceryId(grocery.getId());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

    @Override
    public void deleteCartItem(Integer id) {
        cartRepository.deleteById(id);
    }
}
