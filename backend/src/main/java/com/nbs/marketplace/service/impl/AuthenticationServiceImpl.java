package com.nbs.marketplace.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.nbs.marketplace.dto.LoginRequest;
import com.nbs.marketplace.dto.LoginResponse;
import com.nbs.marketplace.security.JwtService;
import com.nbs.marketplace.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        String token = jwtService.generateToken(request.getEmail());

        LoginResponse response = new LoginResponse();
        response.setToken(token);
        response.setMessage("Login successful");

        return response;
    }
}