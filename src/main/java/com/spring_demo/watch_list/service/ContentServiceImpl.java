package com.spring_demo.watch_list.service;

import com.spring_demo.watch_list.dao.CategoryDAO;
import com.spring_demo.watch_list.dao.ContentDAO;
import com.spring_demo.watch_list.entity.Category;
import com.spring_demo.watch_list.entity.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentDAO contentDAO;
    private final CategoryDAO categoryDAO;

    @Override
    public Content saveContentWithCategories(Content content, List<Integer> categoryIds) {
        List<Category> existingCategories = categoryDAO.findAllById(categoryIds);

        if (existingCategories.isEmpty()) {
            throw new RuntimeException("No valid categories found.");
        }

        content.setCategories(existingCategories);

        if (content.getType() == null) {
            throw new IllegalArgumentException("Content type cannot be null.");
        }

        return contentDAO.save(content);
    }

    public List<Content> getAllContents(){
        return contentDAO.findAll();
    }

    public Content addContent(Content content){
        return contentDAO.save(content);
    }

    public void deleteContent(int id){
        contentDAO.deleteById(id);
    }
}
