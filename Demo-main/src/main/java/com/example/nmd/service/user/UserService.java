package com.example.nmd.service.user;

import com.example.nmd.dto.request.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    ResponseEntity<?> createUser(CreateUserRequest request);
    ResponseEntity<?> getUserById(CreateUserRequest request);
    ResponseEntity<?> getAllUser( );

    ResponseEntity<?> updateuser(CreateUserRequest request);
    boolean deleteUser(CreateUserRequest request);
}
