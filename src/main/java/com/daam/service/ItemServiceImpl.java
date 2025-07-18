package com.daam.service;

import com.daam.model.Item;
import com.daam.model.dto.ItemDto;
import com.daam.model.MenuItem;
import com.daam.model.Order;
import com.daam.repo.ItemRepo;
import com.daam.repo.MenuItemRepo;
import com.daam.repo.OrderRepo;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo repo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private MenuItemRepo menuItemRepo;

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
            Item oldItem = repo.findById(id).get();
            item.setOrder(oldItem.getOrder());
            item.setItem(oldItem.getItem());
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
    public List<Item> addItemsToOrder(ItemDto[] items, int id) {
        Order order = new Order();
        order.setId(id);
        List<Item> itemList = new ArrayList<>();

//        TODO can I check if an entity exists in another table?
        for (ItemDto item : items) {
            Item savedItem = repo.save(dtoToItem(item, id));
            itemList.add(savedItem);
        }
        return itemList;
    }

    private Item dtoToItem(ItemDto itemDto, int orderId) {
        Item item = new Item();

        // Set order reference by id
        Order order = orderRepo.findById(orderId)
                .orElse(null);
        if (order == null) {
            throw new NoRecordException("Order not found");
        }
        item.setOrder(order);

        // Set menuitem reference by id
        MenuItem menuItem = menuItemRepo.findById(itemDto.getMenuItemId()).orElse(null);
        if (menuItem == null) {
            throw new NoRecordException("MenuItem not found");
        }
        item.setItem(menuItem);

        item.setPrice(itemDto.getPrice());
        item.setNotes(itemDto.getNotes());
        item.setFirstName(itemDto.getFirstName());

        return item;
    }
}
