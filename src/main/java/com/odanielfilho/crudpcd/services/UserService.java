package com.odanielfilho.crudpcd.services;

import com.odanielfilho.crudpcd.entities.User;
import com.odanielfilho.crudpcd.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(@NotNull User user) {
        User createdUser = repository.findByUsername(user.getUsername());
        if (createdUser != null) {
            throw new Error("User already exists");
        }
        return repository.save(user);
    }

    public List<User> getUsers() {
     return repository.findAll();
    }

    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    public  User updateUser(UUID id, User userUpdate) {
        User user = repository.findById(id).orElse(null);
        if (user != null) {
            if (userUpdate.getUsername() != null) {
                user.setUsername(userUpdate.getUsername());
            }
            if (userUpdate.getEmail() != null) {
                user.setEmail(userUpdate.getEmail());
            }
            if (userUpdate.getPassword() != null) {
                user.setPassword(userUpdate.getPassword());
            }
            user = repository.save(user);
        }
        return user;
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
