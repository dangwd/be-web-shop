package com.example.nmd.controller;

import com.example.nmd.dto.request.CreateUserRequest;
import com.example.nmd.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getById(@RequestBody CreateUserRequest request) {
        return userService.getUserById(request);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("")
    public ResponseEntity<?> updateUser(@RequestBody CreateUserRequest request) {
        return userService.updateuser(request);
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        return userService.getAllUser();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok().body(userService.deleteUser(request));
    }
}
