package com.daam.service;

import com.daam.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAll();

    MenuItem getById(int id);

    MenuItem addMenuItem(MenuItem menuItem);

    MenuItem updateMenuItem(int id, MenuItem menuItem);

    void deleteMenuItem(int id);
}
