package com.exemple.controller;

import com.exemple.entity.User;
import com.exemple.service.InterfaceUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class AuthController {

    private InterfaceUserService interfaceUserService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/")
    public String login()
    {
        return "auth/login";
    }

    @PostMapping("/login")
    public String auth(@RequestParam String email, @RequestParam String password, Model model, HttpSession session)
    {
        if(interfaceUserService.authenticate(email, password) != null)
        {
            User user = interfaceUserService.authenticate(email, password);
            session.setAttribute("name", user.getName());
            return "/dashboard";
        }else{
            model.addAttribute("error", "Fail login with this email & password try again !");
            return "auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute("name");
        return "redirect:/";
    }

}
