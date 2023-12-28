package com.exemple.controller;

import com.exemple.entity.User;
import com.exemple.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListController {

    @Autowired
    private InterfaceUserService interfaceUserService;

    @GetMapping("/list")
    public String list(ModelMap modelMap)
    {
        List<User> users = interfaceUserService.getUsers();
        System.out.println(users);
        modelMap.addAttribute("users", users);
        return "list";
    }
}
