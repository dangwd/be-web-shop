package com.example.nmd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "image")
    private String image ;
    @Column(name = "type")
    private String type ;

    private String tile ;
}
