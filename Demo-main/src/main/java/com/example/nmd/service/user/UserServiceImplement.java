package com.example.nmd.service.user;

import com.example.nmd.dto.request.CreateUserRequest;
import com.example.nmd.dto.response.BaseItemResponse;
import com.example.nmd.dto.response.BaseListResponse;
import com.example.nmd.model.User;
import com.example.nmd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> createUser(CreateUserRequest request) {
        User user = User.builder().id(UUID.randomUUID().toString())
                .password(request.getPassword())
                .email(request.getEmail()).build();
        BaseItemResponse response = new BaseItemResponse();
        response.setSuccess(true);
        response.setData(userRepository.saveAndFlush(user));
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> getUserById(CreateUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Khong tim thay id"));
        BaseItemResponse response = new BaseItemResponse();
        response.setSuccess(true);
        response.setData(user);
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> getAllUser() {
        List<User> users = userRepository.findAll();
        BaseListResponse response = new BaseListResponse();
        response.setSuccess(true);
        response.setResult(users, users.size());
        return ResponseEntity.ok().body(response);
    }

    @Override
    public ResponseEntity<?> updateuser(CreateUserRequest request) {
        User user = userRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException("Khong tim thay id nguoi dung"));
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        BaseItemResponse response = new BaseItemResponse();
        response.setSuccess(true);
        response.setData(userRepository.saveAndFlush(user));
        return ResponseEntity.ok().body(response);
    }

    @Override
    public boolean deleteUser(CreateUserRequest request) {
        Optional<User> user = userRepository.findById(request.getId());
        if (!user.isPresent()) {
            return false;
        }
        userRepository.deleteById(request.getId());
        return true;
    }
}
