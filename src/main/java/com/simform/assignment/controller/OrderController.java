package com.simform.assignment.controller;

import com.simform.assignment.entity.Order;
import com.simform.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    @GetMapping

    public ResponseEntity<List<Order>> getAll() {
        List<Order> orderList = orderService.getAll();
        return new ResponseEntity<>(orderList, HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") Long id ) {
        Order orderByID = orderService.getById(id);
        return new ResponseEntity<>(orderByID,HttpStatus.FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        orderService.deleteById(id);
        return new ResponseEntity<>("Message : Order Deleted with id : " + id,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id , @RequestBody Order order) {
        orderService.update(id,order);
        return new ResponseEntity<>("Message : Updated order where id = : " + id , HttpStatus.OK);
    }


}
