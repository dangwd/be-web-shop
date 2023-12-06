package com.example.nmd.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CreateUserRequest {
    private String email ;
    private String password ;
    private String id ;

}
