package com.akrams.qp_assessment.dto;



import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GroceryDto {

    private Integer groceryId;
    private String name;
    private Double price;
    private Date addedAt;
    private Date updatedAt;

    public Integer getGroceryId() {
        return groceryId;
    }

    public void setGroceryId(Integer groceryId) {
        this.groceryId = groceryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
