package com.exemple.service;

import com.exemple.entity.User;

import java.util.List;

public interface InterfaceUserService {

    List<User> getUsers();
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User getById(Long id);
    User authenticate(String email, String password);
    User getByEmail(String email);
}
