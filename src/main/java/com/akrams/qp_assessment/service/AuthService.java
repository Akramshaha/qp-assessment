package com.akrams.qp_assessment.service;

import com.akrams.qp_assessment.dto.LoginDto;

public interface AuthService {

    String login(LoginDto loginDto);

    Integer getUserIdFromToken(String token);
}
