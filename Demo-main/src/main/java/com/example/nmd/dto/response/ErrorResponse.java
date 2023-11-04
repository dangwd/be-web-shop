package com.example.nmd.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @author MinhDV
 */
@Data
public class ErrorResponse {
    private int code;
    private String message;
    private List<ErrorDetail> errors;
}
