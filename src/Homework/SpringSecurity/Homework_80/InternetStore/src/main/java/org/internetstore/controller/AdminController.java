package org.internetstore.controller;

import jakarta.servlet.http.HttpSession;
import org.internetstore.entity.Category;
import org.internetstore.entity.Goods;
import org.internetstore.entity.User;
import org.internetstore.repository.UserRepo;
import org.internetstore.service.ICategoryService;
import org.internetstore.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ICategoryService categoryService;

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
    public String loadAddItem(Model m){
        List<Category> categories = categoryService.getAllCategory();
        m.addAttribute("categories", categories);
        return "admin/add_item";
    }

    @GetMapping("/loadAddCategory")
    public String loadAddCategory(Model m){
        m.addAttribute("categories", categoryService.getAllCategory());
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category, HttpSession session, @RequestParam("file") MultipartFile image) throws IOException {
        Boolean existCategory = categoryService.existCategory(category.getName());
        if (existCategory) {
            session.setAttribute("errorMsg", "Категория уже существует");
        } else {
            String imageName = image.isEmpty() ? "default.jpg" : image.getOriginalFilename();
            category.setImage(imageName);
            Category saveCategory = categoryService.saveCategory(category);
            if (saveCategory != null) {
                String saveFile = new File("src/main/resources/static/images").getAbsolutePath();
                if (!image.isEmpty()) {
                    Path path = Paths.get(saveFile + File.separator + "category_img" + File.separator + image.getOriginalFilename());
                    Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                }
                session.setAttribute("successMsg", "Категория добавлена");
            } else {
                session.setAttribute("errorMsg", "Ошибка добаления категории");
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

    @GetMapping("/loadEditCategory/{id}")
    public String loadEditCategory(@PathVariable int id, Model m){
        m.addAttribute("category", categoryService.getCategoryById(id));
        return "admin/edit_category";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@ModelAttribute Category category, HttpSession session){
        Category oldCategory = categoryService.getCategoryById(category.getId());
        if(oldCategory != null){
            oldCategory.setName(category.getName());
        }
    Category updateCategory = categoryService.saveCategory(oldCategory);
        if(updateCategory != null){
            session.setAttribute("successMsg", "Категория обновлена");
        } else{
            session.setAttribute("errorMsg", "Ошибка обновления категории");
        }
        return "redirect:/admin/loadAddCategory";
    }

    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute Goods good, HttpSession session, @RequestParam("file") MultipartFile image) throws IOException {
        String imageName = image.isEmpty() ? "default.jpg" : image.getOriginalFilename();
        good.setImage(imageName);
        Goods saveGood = goodsService.saveGood(good);
        if(saveGood != null){
            String saveFile = new File("src/main/resources/static/images").getAbsolutePath();
            if(!image.isEmpty()){
                Path path = Paths.get(saveFile + File.separator + "goods" + File.separator + image.getOriginalFilename());
                Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }
            session.setAttribute("successMsg", "Товар добавлен");
        } else {
            session.setAttribute("errorMsg", "Ошибка добаления товара");
        }
        return "redirect:/admin/loadAddItem";
    }

    @GetMapping("/items")
    public String loadViewGoods(Model m){
        m.addAttribute("goods", goodsService.getAllGoods());
        return "admin/items";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id, HttpSession session){
        Boolean deleteItem = goodsService.deleteGood(id);
        if(deleteItem){
            session.setAttribute("successMsg", "Товар удален");
        } else{
            session.setAttribute("errorMsg", "Ошибка удаления товара");
        }
        return "redirect:/admin/items";
    }
}
