package com.daam.controller;

import com.daam.model.Order;
import com.daam.service.OrderService;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService service;

    @GetMapping
    public List<Order> getOrders() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
        try {
            return service.update(id, order);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable int id) {
        try {
            service.delete(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/orders/user/{id}")
    public List<Order> getOrdersByUserId(@PathVariable int id) {
        return service.getByUserId(id);
    }
}
