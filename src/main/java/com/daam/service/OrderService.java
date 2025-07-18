package com.daam.service;

import com.daam.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order getById(int id);

    Order create(Order order);

    Order update(int id, Order order);

    void delete(int id);

    List<Order> getByUserId(int id);
}
