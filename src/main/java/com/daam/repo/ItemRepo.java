package com.daam.repo;

import com.daam.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends CrudRepository<Item, Integer> {
    @Query("FROM Item i WHERE i.order.id = :id")
    List<Item> findByOrderId(@Param("id") Integer id);
}
