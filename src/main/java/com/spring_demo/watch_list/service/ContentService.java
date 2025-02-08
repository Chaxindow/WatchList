package com.spring_demo.watch_list.service;

import com.spring_demo.watch_list.entity.Content;

import java.util.List;

public interface ContentService {
    Content saveContentWithCategories(Content content, List<Integer> categoryIds);
    List<Content> getAllContents();
    Content addContent(Content content);
    void deleteContent(int id);
}
