package com.example.nmd.repository;

import com.example.nmd.dto.request.FilterOrderRequest;
import com.example.nmd.model.Order;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomOrderRepository {
    public static Specification<Order> filterSpecification(FilterOrderRequest request){
        return (((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.hasText(request.getEmail())){
                predicates.add(criteriaBuilder.like(root.get("email") ,"%" +request.getEmail() +"%"));
            }
            if(StringUtils.hasText(request.getName())){
                predicates.add(criteriaBuilder.like(root.get("name") ,"%" +request.getName() +"%"));

            }
            if(StringUtils.hasText(request.getPhoneNumber())){
                predicates.add(criteriaBuilder.like(root.get("phoneNumber") ,"%" +request.getPhoneNumber() +"%"));
            }
            if(StringUtils.hasText(request.getAddr())){
                predicates.add(criteriaBuilder.like(root.get("addr") ,"%" +request.getAddr() +"%"));
            }
            if (request.getOrderCreationDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("orderCreationDate"), request.getOrderCreationDate()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));
    }


}
