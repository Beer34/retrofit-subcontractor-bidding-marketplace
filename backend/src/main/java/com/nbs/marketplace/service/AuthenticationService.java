package com.nbs.marketplace.service;

import com.nbs.marketplace.dto.LoginRequest;
import com.nbs.marketplace.dto.LoginResponse;

public interface AuthenticationService {

    LoginResponse login(LoginRequest request);

}