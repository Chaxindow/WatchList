package com.spring_demo.watch_list.service;

import com.spring_demo.watch_list.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    void deleteCategory(int id);
}
