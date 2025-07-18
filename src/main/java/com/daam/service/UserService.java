package com.daam.service;

import com.daam.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User createUser(User user);

    User getUserById(int id);

    User update(int id, User user);

    void delete(int id);
}
