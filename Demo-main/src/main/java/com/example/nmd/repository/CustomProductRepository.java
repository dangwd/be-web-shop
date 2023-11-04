package com.example.nmd.repository;

import com.example.nmd.dto.request.FilterProduct;
import com.example.nmd.model.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomProductRepository {
    public static Specification<Product> filterSpecification(FilterProduct request) {
        return (((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(request.getName())) {
                predicates.add(criteriaBuilder.like(root.get("productName"), "%" + request.getName() + "%"));
            }
            if(request.getPriceFrom() != null && request.getPriceTo() != null){
                predicates.add(criteriaBuilder.between(root.get("price"), request.getPriceFrom() , request.getPriceTo()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }));

    }
}
