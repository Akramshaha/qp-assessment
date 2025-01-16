package com.akrams.qp_assessment.controller;

import com.akrams.qp_assessment.dto.JwtAuthResponse;
import com.akrams.qp_assessment.dto.LoginDto;
import com.akrams.qp_assessment.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        HttpHeaders httpheaders = new HttpHeaders();

        // Set the Authorization header
        httpheaders.set("Authorization", token);

        return ResponseEntity.ok().headers(httpheaders).body(jwtAuthResponse);
    }
}
