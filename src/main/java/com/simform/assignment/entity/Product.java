package com.simform.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "product_id")
        private Long id;
        @Column(name = "product_name")
        private String name;
        @ManyToMany(mappedBy = "products")
        @JsonBackReference
        private List<Order> orders = new ArrayList<>();
        public void addOrder(Order order) {
            orders.add(order);
        }
    }
