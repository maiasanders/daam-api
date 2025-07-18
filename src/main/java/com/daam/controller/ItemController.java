package com.daam.controller;

import com.daam.model.Item;
import com.daam.model.dto.ItemDto;
import com.daam.service.ItemService;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private ItemService service;

    @GetMapping
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable int id){
        try {
            return service.getById(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable int id, @RequestBody ItemDto item) {
        try {
            return service.update(id, item);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        try {
            service.deleteById(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/order/{id}")
    public List<Item> getByOrderId(@PathVariable int id) {
        return service.getByOrderId(id);
    }

    @PostMapping("/order/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Item> create(@RequestBody ItemDto[] items, @PathVariable int id) {
        return service.addItemsToOrder(items, id);
    }

    @DeleteMapping("/order/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItemsFromOrder(@PathVariable int id) {
        try {
            service.deleteAllFromOrder(id);
        } catch (NoRecordException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
