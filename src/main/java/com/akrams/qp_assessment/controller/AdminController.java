package com.akrams.qp_assessment.controller;

import com.akrams.qp_assessment.dto.GroceryDto;
import com.akrams.qp_assessment.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private GroceryService groceryService;

    @GetMapping("/")
    public ResponseEntity<String> helloAdmin(){
        return ResponseEntity.ok("Accessible to Admin Only");
    }

    @PostMapping("/groceries/add")
    public ResponseEntity<?> addNewGrocery(@RequestBody GroceryDto groceryDto){
        GroceryDto groceryDto1 = groceryService.addNewGrocery(groceryDto);
        return ResponseEntity.ok(groceryDto1);
    }

    @PutMapping("/groceries/update")
    public ResponseEntity<?> updateGrocery(@RequestBody GroceryDto groceryDto){
        GroceryDto groceryDto1 = groceryService.updateGrocery(groceryDto);
        return ResponseEntity.ok(groceryDto1);
    }

    @DeleteMapping("/groceries/delete/{id}")
    public ResponseEntity<?> deleteGrocery(@PathVariable Integer id){
        groceryService.removeGrocery(id);
        return ResponseEntity.ok("Grocery No. "+id+" is Deleted");
    }

    @GetMapping("/groceries/{id}")
    public ResponseEntity<?> findGrocery(@PathVariable Integer id){
        GroceryDto groceryDto = groceryService.findById(id);
        return ResponseEntity.ok(groceryDto);
    }
}
