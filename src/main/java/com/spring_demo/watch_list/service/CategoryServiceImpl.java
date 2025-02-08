package com.spring_demo.watch_list.service;

import com.spring_demo.watch_list.dao.CategoryDAO;
import com.spring_demo.watch_list.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Override
    public Category saveCategory(Category category) {
        return categoryDAO.findByName(category.getName()).
                orElseGet(() -> categoryDAO.save(category));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteCategory(int id) {
        categoryDAO.deleteById(id);
    }
}
