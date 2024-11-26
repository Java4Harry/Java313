package org.internetstore.service;

import org.internetstore.entity.Category;

import java.util.List;

public interface ICategoryService {
    public Category saveCategory(Category category);
    public List<Category> getAllCategory();
    public Boolean existCategory(String name);
    public Boolean deleteCategory(int id);
    public Category getCategoryById(int id);
}
