package com.daam.service;

import com.daam.model.User;
import com.daam.repo.UserRepo;
import com.daam.service.exception.NoRecordException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;


    @Override
    public List<User> getUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new NoRecordException("User not found");
        }
        return user.get();
    }

    @Override
    public User update(int id, User user) {
        if (userRepo.findById(id).isPresent()) {
            return userRepo.save(user);
        } else  {
            throw new NoRecordException("User not found");
        }
    }

    @Override
    public void delete(int id) {
        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
        } else {
            throw new NoRecordException("User not found");
        }
    }
}
