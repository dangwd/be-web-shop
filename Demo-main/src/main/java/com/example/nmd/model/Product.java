package com.example.nmd.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")

public class Product {
    @Id
    @Column(name = "product_id")
    private String productId ;

    @Column
    private float price ;
    @Column
    private String image;
    @Column(name = "product_name")
    private  String productName;
    @Column
    private String description ;
    @Column(name = "type")
    private String type ;
    @Column(name = "create_time")
    private Date createTime ;
    @Column
    private long quantityInStore = 0;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderItem> orderItems;










}

