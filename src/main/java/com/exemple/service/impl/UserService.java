package com.exemple.service.impl;

import com.exemple.entity.User;
import com.exemple.repository.InterfaceUserRepository;
import com.exemple.service.InterfaceUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements InterfaceUserService {

    private InterfaceUserRepository interfaceUserRepository;

    @Override
    public List<User> getUsers() {
        return interfaceUserRepository.findAll();
    }

    @Override
    public User addUser(User user)
    {
        return interfaceUserRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return interfaceUserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        interfaceUserRepository.deleteById(id);
    }

    @Override
    public User getById(Long id)
    {
        return interfaceUserRepository.findById(id).orElse(null);
    }

    @Override
    public User authenticate(String email, String password)
    {
        User user = interfaceUserRepository.findUserByEmail(email);
        if(user.getPassword().equals(password))
        {
            return user;
        }

        return null;
    }

    @Override
    public User getByEmail(String email)
    {
        return interfaceUserRepository.findUserByEmail(email);
    }

}
