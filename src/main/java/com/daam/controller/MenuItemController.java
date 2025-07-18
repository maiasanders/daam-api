package com.daam.controller;

import com.daam.model.MenuItem;
import com.daam.service.MenuItemService;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/menuitems")
@AllArgsConstructor
public class MenuItemController {
    private MenuItemService service;

    @GetMapping
    public List<MenuItem> getMenuItems() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return service.addMenuItem(menuItem);
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItem(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable int id, @RequestBody MenuItem menuItem) {
        try {
            return service.updateMenuItem(id, menuItem);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenuItem(@PathVariable int id) {
        try {
            service.deleteMenuItem(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
