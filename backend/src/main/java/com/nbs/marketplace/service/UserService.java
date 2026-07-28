package com.nbs.marketplace.service;

import com.nbs.marketplace.dto.RegisterRequest;
import com.nbs.marketplace.dto.UserResponse;

public interface UserService {

    UserResponse registerUser(RegisterRequest request);

}