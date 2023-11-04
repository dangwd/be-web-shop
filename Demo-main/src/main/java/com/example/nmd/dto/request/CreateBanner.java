package com.example.nmd.dto.request;

import lombok.Data;

@Data
public class CreateBanner {
    private long id ;
    private String type ;
    private String image ;
    private String title ;
}
