package com.exemple.controller;

import com.exemple.entity.User;
import com.exemple.service.InterfaceUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private InterfaceUserService interfaceUserService;

    @GetMapping
    public String getAllUsers(Model model)
    {
        List<User> users = interfaceUserService.getUsers();
        model.addAttribute("users", users);
        return "/users/list";
    }

    @GetMapping("/create")
    public String showFormUser(Model model)
    {
        model.addAttribute("user", new User());
        return "users/create";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user)
    {
        interfaceUserService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model)
    {
        User user = interfaceUserService.getById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user)
    {
        interfaceUserService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        interfaceUserService.deleteUser(id);
        return "redirect:/users";
    }
}
