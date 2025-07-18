package com.daam.service;

import com.daam.model.Order;
import com.daam.repo.OrderRepo;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo repo;

    @Override
    public List<Order> getAll() {
        return (List<Order>) repo.findAll();
    }

    @Override
    public Order getById(int id) {
        Optional<Order> order = repo.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        throw new NoRecordException("Order Not Found");
    }

    @Override
    public Order create(Order order) {
        return repo.save(order);
    }

    @Override
    public Order update(int id, Order order) {
        if (repo.existsById(id)) {
            return repo.save(order);
        }
        throw new NoRecordException("Order Not Found");
    }

    @Override
    public void delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new NoRecordException("Order Not Found");
        }
    }

    @Override
    public List<Order> getByUserId(int id) {
        return (List<Order>) repo.findByUserId(id);
    }
}
