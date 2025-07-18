package com.daam.service;

import com.daam.model.MenuItem;
import com.daam.repo.MenuItemRepo;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepo menuItemRepo;

    @Override
    public List<MenuItem> getAll() {
        return (List<MenuItem>) menuItemRepo.findAll();
    }

    @Override
    public MenuItem getById(int id) {
        Optional<MenuItem> item = menuItemRepo.findById(id);
        if (item.isEmpty()) {
            throw new NoRecordException("Item not found");
        }
        return item.get();
    }

    @Override
    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepo.save(menuItem);
    }

    @Override
    public MenuItem updateMenuItem(int id, MenuItem menuItem) {
        if (menuItemRepo.existsById(id)) {
            return menuItemRepo.save(menuItem);
        }
        throw new NoRecordException("Item not found");
    }

    @Override
    public void deleteMenuItem(int id) {
        if (menuItemRepo.existsById(id)) {
            menuItemRepo.deleteById(id);
        } else {
            throw new NoRecordException("Item not found");
        }
    }
}
