package com.daam.repo;

import com.daam.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Integer> {

    @Query("FROM Order o WHERE o.user.id = :id")
    public List<Order> findByUserId(@Param("id") Integer id);
}
