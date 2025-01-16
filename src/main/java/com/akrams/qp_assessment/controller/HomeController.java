package com.akrams.qp_assessment.controller;

import com.akrams.qp_assessment.dto.AddToCartDto;
import com.akrams.qp_assessment.dto.CartCost;
import com.akrams.qp_assessment.dto.GroceryDto;
import com.akrams.qp_assessment.dto.ResponseDto;
import com.akrams.qp_assessment.model.Grocery;
import com.akrams.qp_assessment.service.AuthService;
import com.akrams.qp_assessment.service.CartService;
import com.akrams.qp_assessment.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groceries")
public class HomeController {

    @Autowired
    private GroceryService groceryService;
    @Autowired
    private AuthService authService;
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public ResponseEntity<?> getAllGroceries(){
        return ResponseEntity.ok(groceryService.findAllGroceries());
    }

    @PostMapping("/cart/add")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestHeader HttpHeaders headers) {
        String header = headers.getFirst("Authorization");
        int userId = authService.getUserIdFromToken(header.split(" ")[1]);
        cartService.addToCart(addToCartDto,userId);
        return ResponseEntity.ok("Item has been Added to cart");

    }
    @GetMapping("/cart")
    public ResponseEntity<?> getCartItems(@RequestHeader HttpHeaders headers) {
        String header = headers.getFirst("Authorization");
        int userId = authService.getUserIdFromToken(header.split(" ")[1]);
        CartCost cartCost = cartService.listCartItems(userId);
        return new ResponseEntity<CartCost>(cartCost, HttpStatus.OK);
    }
    @PutMapping("/cart/update")
    public ResponseEntity<?> updateCartItem(@RequestBody AddToCartDto cartDto,@RequestHeader HttpHeaders headers) {
        String header = headers.getFirst("Authorization");
        int userId = authService.getUserIdFromToken(header.split(" ")[1]);

        Grocery grocery = groceryService.findGroceryById(cartDto.getGroceryId());

        cartService.updateCartItem(cartDto,userId,grocery);
        return ResponseEntity.ok(grocery);
    }

    @DeleteMapping("/cart/delete/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable Integer id) {
        cartService.deleteCartItem(id);
        return ResponseEntity.ok("Cart Item Removed");
    }

}
