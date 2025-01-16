package com.akrams.qp_assessment.dto;

import com.akrams.qp_assessment.model.Grocery;
import lombok.Builder;

import java.util.List;

@Builder
public class ResponseDto {

    private GroceryDto groceryDto;
    private List<Grocery> groceryList;
    private String message;

    public GroceryDto getGroceryDto() {
        return groceryDto;
    }

    public void setGroceryDto(GroceryDto groceryDto) {
        this.groceryDto = groceryDto;
    }

    public List<Grocery> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(List<Grocery> groceryList) {
        this.groceryList = groceryList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDto(GroceryDto groceryDto, List<Grocery> groceryList, String message) {
        this.groceryDto = groceryDto;
        this.groceryList = groceryList;
        this.message = message;
    }


}
