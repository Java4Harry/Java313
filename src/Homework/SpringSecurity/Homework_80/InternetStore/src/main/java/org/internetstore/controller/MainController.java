package org.internetstore.controller;

import jakarta.servlet.http.HttpSession;
import org.internetstore.entity.User;
import org.internetstore.repository.UserRepo;
import org.internetstore.service.IUserService;
import org.internetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @ModelAttribute
    public void commonUser(Principal principal, Model model) {
        if (principal != null) {
            String email = principal.getName();
            User user = userRepo.findByEmail(email);
            model.addAttribute("user", user);
        }
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/profile")
    public String profile(Principal principal, Model model) {
        String email = principal.getName();
        User user = userRepo.findByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user/about")
    public String about() {
        return "about";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session) {
        User u = userService.saveUser(user);
        if (u != null) {
            session.setAttribute("msg", "Пользователь зарегестрирован");
        } else {
            session.setAttribute("msg", "Ошибка регистрации");
        }
        return "redirect:/register";
    }
}
