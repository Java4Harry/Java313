package org.internetstore.controller;

import jakarta.servlet.http.HttpSession;
import org.internetstore.entity.Category;
import org.internetstore.entity.Goods;
import org.internetstore.entity.User;
import org.internetstore.repository.UserRepo;
import org.internetstore.service.ICategoryService;
import org.internetstore.service.IGoodsService;
import org.internetstore.service.IUserService;
import org.internetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IGoodsService goodsService;

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
    public String index(Model m) {
        List<Category> categories = categoryService.getAllCategory();
        m.addAttribute("categories", categories);
        List<Goods> goods = goodsService.getAllGoods();
        m.addAttribute("goods", goods);
        return "index";
    }

    @GetMapping("/about")
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

    @GetMapping("/item/{id}")
    public String item(@PathVariable int id, Model m){
        Goods goodById = goodsService.getGoodById(id);
        m.addAttribute("good", goodById);
        return "view_item";
    }

    @GetMapping("/categories/{name}")
    public String categories(@PathVariable String name, Model m, @RequestParam(name="pageNo", defaultValue = "0") Integer pageNo, @RequestParam(name="pageSize", defaultValue = "4") Integer pageSize){
        List<Category> categories = categoryService.getAllCategory();
        m.addAttribute("categories", categories);
//        m.addAttribute("goodsInCategory", goodsService.getGoodsByCategory(name));
        m.addAttribute("category", name);
        Page<Goods> page = goodsService.getAllGoodsPagination(pageNo, pageSize, name);
        List<Goods> goods = page.getContent();
        m.addAttribute("goodsInCategory", goods);
        m.addAttribute("goodsSize", goodsService.getGoodsByCategory(name).size());
        m.addAttribute("pageNo", page.getNumber());
        m.addAttribute("pageSize", pageSize);
        m.addAttribute("totalGoods", page.getTotalElements());
        m.addAttribute("totalPages", page.getTotalPages());
        m.addAttribute("isLast", page.isLast());
        m.addAttribute("isFirst", page.isFirst());
        return "view_category";
    }

    @GetMapping("/search")
    public String searchItem(@RequestParam String ch, Model m){
        List<Goods> searchGoods = goodsService.searchGoods(ch);
        m.addAttribute("goodsInCategory", searchGoods);
        List<Category> categories = categoryService.getAllCategory();
        m.addAttribute("categories", categories);
        return "view_category";
    }
}
