package com.daam.service;

import com.daam.model.Item;
import com.daam.model.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<Item> getAll();

    Item getById(int id);

    Item update(int id, Item item);

    void deleteById(int id);

    List<Item> getByOrderId(int id);

    List<Item> addItemsToOrder(ItemDto[] items, int id);
}
