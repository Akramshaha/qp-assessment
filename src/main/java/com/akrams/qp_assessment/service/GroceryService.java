package com.akrams.qp_assessment.service;

import com.akrams.qp_assessment.dto.GroceryDto;
import com.akrams.qp_assessment.model.Grocery;

import java.util.List;

public interface GroceryService {

    GroceryDto addNewGrocery(GroceryDto grocery);
    GroceryDto updateGrocery(GroceryDto grocery);
    void removeGrocery(Integer id);
    List<Grocery> findAllGroceries();
    GroceryDto findById(Integer id);
    Grocery findGroceryById(Integer id);


}
