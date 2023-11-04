package com.example.nmd.exception;

//import com.gogroup.dto.response.ErrorDetail;
import com.example.nmd.dto.response.ErrorDetail;
import lombok.Data;

import java.util.List;

@Data
public class ErrorDetailException extends RuntimeException{
    private final List<ErrorDetailException> errorDetails;
    public ErrorDetailException(List<ErrorDetailException> errorDetails) {
        this.errorDetails = errorDetails;
    }
}
