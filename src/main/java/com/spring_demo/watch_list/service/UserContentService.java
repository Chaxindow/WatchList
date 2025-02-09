package com.spring_demo.watch_list.service;

import com.spring_demo.watch_list.entity.UserContent;

import java.util.List;
import java.util.Optional;

public interface UserContentService {
    List<UserContent> getUserContents(String userId);
    Optional<UserContent> getUserContentById(String userId, int contentId);
    UserContent addUserContent(UserContent userContent);
    UserContent updateUserContent(UserContent userContent);
    void deleteUserContent(String userId, int contentId);
}
