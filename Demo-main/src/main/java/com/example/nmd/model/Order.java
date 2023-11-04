package com.example.nmd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "order_product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "addr")
    private String addr;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "total_value_order")
    private Float totalValueOrder = 0.0f;

    @Column(name = "order_creation_date")
    private Date orderCreationDate;

    @Column(name = "status_id")
    private String status;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "order")
//    private List<OrderItem> orderItems ;






}
