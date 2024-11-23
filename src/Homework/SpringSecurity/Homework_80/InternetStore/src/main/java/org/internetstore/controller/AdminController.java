package org.internetstore.controller;

import jakarta.servlet.http.HttpSession;
import org.internetstore.entity.Category;
import org.internetstore.entity.User;
import org.internetstore.repository.UserRepo;
import org.internetstore.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        String email = principal.getName();
        User user = userRepo.findByEmail(email);
        model.addAttribute("user", user);
        return "admin/profile";
    }

    @GetMapping("/")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/loadAddItem")
    public String loadAddItem(){
        return "admin/add_item";
    }

    @GetMapping("/loadAddCategory")
    public String loadAddCategory(Model m){
        m.addAttribute("categories", categoryService.getAllCategory());
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, HttpSession session){
        Boolean existCategory = categoryService.existCategory(category.getName());
        if(existCategory){
            session.setAttribute("errorMsg", "Категория уже существует");
        } else {
            Category saveCategory = categoryService.saveCategory(category);
            if(saveCategory != null){
                session.setAttribute("successMsg", "Категория сохранена");
            } else {
                session.setAttribute("errorMsg", "Ошибка сохранения категории");
            }
        }
        return "redirect:/admin/loadAddCategory";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, HttpSession session){
        Boolean deleteCategory = categoryService.deleteCategory(id);
        if(deleteCategory){
            session.setAttribute("successMsg", "Категория удалена");
        } else {
            session.setAttribute("errorMsg", "Ошибка удаления категории");
        }
        return "redirect:/admin/loadAddCategory";
    }
}
