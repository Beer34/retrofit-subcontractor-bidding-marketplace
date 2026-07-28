package com.nbs.marketplace.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nbs.marketplace.dto.RegisterRequest;
import com.nbs.marketplace.dto.UserResponse;
import com.nbs.marketplace.entity.User;
import com.nbs.marketplace.repository.UserRepository;
import com.nbs.marketplace.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse registerUser(RegisterRequest request) {

        // Check if the email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists.");
        }

        // Create a new User entity
        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setRole(request.getRole());

        // Save the user
        User savedUser = userRepository.save(user);

        // Prepare response
        UserResponse response = new UserResponse();

        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setPhone(savedUser.getPhone());
        response.setAddress(savedUser.getAddress());
        response.setRole(savedUser.getRole());

        return response;
    }
}