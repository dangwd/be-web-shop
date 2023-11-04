package com.example.nmd.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FilterProduct {
    @NotNull(message = "Không được để trống số trang bắt đầu ")
    private int start;
    @NotNull(message ="Không được để trống số lượng trang ")
    private int limit;
    private String name;
    private Float priceFrom;
    private Float priceTo;
}
