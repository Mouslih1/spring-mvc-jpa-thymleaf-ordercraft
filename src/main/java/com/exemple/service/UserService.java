package com.exemple.service;

import com.exemple.entity.User;
import com.exemple.repository.InterfaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements InterfaceUserService{

    @Autowired
    private InterfaceUserRepository interfaceUserRepository;

    @Override
    @Transactional
    public List<User> getUsers() {
        return interfaceUserRepository.findAll();
    }
}
