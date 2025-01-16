package com.akrams.qp_assessment.controller;

import com.akrams.qp_assessment.dto.GroceryDto;
import com.akrams.qp_assessment.dto.ResponseDto;
import com.akrams.qp_assessment.service.GroceryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private GroceryService groceryService;

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/")
    public ResponseEntity<String> helloAdmin(){
        return ResponseEntity.ok("Accessible to Admin Only");
    }

    @PostMapping("/groceries/add")
    public ResponseEntity<?> addNewGrocery(@RequestBody GroceryDto groceryDto){
        GroceryDto groceryDto1 = groceryService.addNewGrocery(groceryDto);
        ResponseDto responseDto = new ResponseDto(groceryDto1, null, "Grocery No. "+groceryDto1.getGroceryId()+" is Added.");
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/groceries/update")
    public ResponseEntity<?> updateGrocery(@RequestBody GroceryDto groceryDto){
        GroceryDto groceryDto1 = groceryService.addNewGrocery(groceryDto);
        ResponseDto responseDto = new ResponseDto(groceryDto1, null, "Grocery No. "+groceryDto1.getGroceryId()+" is Updated.");
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/groceries/delete/{id}")
    public ResponseEntity<?> deleteGrocery(@RequestParam Integer id){
        groceryService.removeGrocery(id);
        return ResponseEntity.ok("Grocery No. "+id+" is Deleted");
    }

    @GetMapping("/groceries/{id}")
    public ResponseEntity<?> findGrocery(@RequestParam Integer id){
        GroceryDto groceryDto = groceryService.findById(id);
        ResponseDto responseDto = new ResponseDto(groceryDto, null, "Grocery No. "+groceryDto.getGroceryId()+" fetched.");
        return ResponseEntity.ok(responseDto);
    }
}
