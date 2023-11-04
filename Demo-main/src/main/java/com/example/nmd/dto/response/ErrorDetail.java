package com.example.nmd.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author MinhDV
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {
    private String id;
    private String message;
}
