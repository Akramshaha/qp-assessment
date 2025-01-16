package com.akrams.qp_assessment.model;

import com.akrams.qp_assessment.dto.AddToCartDto;
import com.akrams.qp_assessment.dto.CartDto;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "grocery_id")
    private Integer groceryId;
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "grocery_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Grocery grocery;

    @Column(name = "created_date")
    private Date createdDate;

    private int quantity;

    private Character status;

    public Cart() {
    }


    public Cart(CartDto cartDto, Grocery grocery, int userId){
        this.userId = userId;
        this.groceryId = cartDto.getGrocery().getId();
        this.quantity = cartDto.getQuantity();
        this.grocery = grocery;
        this.createdDate = new Date();
    }

    public Cart( Integer userId, Integer groceryId, int quantity) {
        this.userId = userId;
        this.groceryId = groceryId;
        this.createdDate = new Date();
        this.quantity = quantity;
    }

    public Cart(CartDto cartDto, Grocery grocery) {
        this.groceryId = cartDto.getGrocery().getId();
        this.quantity = cartDto.getQuantity();
        this.grocery = grocery;
        this.createdDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(Integer groceryId) {
        this.groceryId = groceryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Grocery getGrocery() {
        return grocery;
    }

    public void setGrocery(Grocery grocery) {
        this.grocery = grocery;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
