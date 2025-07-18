package com.daam.service;

import com.daam.model.Item;
import com.daam.repo.ItemRepo;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo repo;

    @Override
    public List<Item> getAll() {
        return (List<Item>) repo.findAll();
    }

    @Override
    public Item getById(int id) {
        Optional<Item> item = repo.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        throw new NoRecordException("Item not found");
    }

    @Override
    public Item update(int id, Item item) {
        if (repo.findById(id).isPresent()) {
            item.setId(id);
            return repo.save(item);
        }
        throw new NoRecordException("Item not found");
    }

    @Override
    public void deleteById(int id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            throw new NoRecordException("Item not found");
        }
    }

    @Override
    public List<Item> getByOrderId(int id) {
        return repo.findByOrderId(id);
    }

    @Override
    public List<Item> addItemsToOrder(Item[] items, int id) {
//        TODO can I check if an entity exists in another table?
        for (Item item : items) {
                item.setId(id);
                repo.save(item);
        }
        return List.of(items);
    }
}
