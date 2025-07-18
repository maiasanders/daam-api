package com.daam.repo;

import com.daam.model.MenuItem;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepo extends CrudRepository<MenuItem, Integer> {
    MenuItem getById(int id);
}
