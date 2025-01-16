package com.akrams.qp_assessment.dto;

import com.akrams.qp_assessment.model.Cart;

public class AddToCartDto {

    private Integer id;
    private Integer userId;
    private Integer groceryId;
    private Integer quantity;

    public AddToCartDto() {
    }

    public AddToCartDto(Integer id, Integer userId, Integer groceryId,  Integer quantity) {
        this.id = id;
        this.userId = userId;
        this.groceryId = groceryId;
        this.quantity = quantity;
    }

    public AddToCartDto(Cart cart) {
        this.setId(cart.getId());
        this.setGroceryId(cart.getGroceryId());
        this.setUserId(cart.getUserId());
        this.setQuantity(cart.getQuantity());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", groceryId=" + groceryId +
                ", quantity=" + quantity +
                ",";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(Integer groceryId) {
        this.groceryId = groceryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
