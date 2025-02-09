package com.spring_demo.watch_list.service;

import com.spring_demo.watch_list.dao.UserContentDAO;
import com.spring_demo.watch_list.entity.UserContent;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserContentServiceImpl implements UserContentService {

    private final UserContentDAO userContentDAO;

    @Override
    public List<UserContent> getUserContents(String userId) {
        return userContentDAO.findByUserId(userId);
    }

    @Override
    public Optional<UserContent> getUserContentById(String userId, int contentId) {
        return userContentDAO.findByUserIdAndContentId(userId,contentId);
    }

    @Override
    public UserContent addUserContent(UserContent userContent) {
        return userContentDAO.save(userContent);
    }

    @Override
    public UserContent updateUserContent(UserContent userContent) {
        Optional<UserContent> existingContent = userContentDAO.findByUserIdAndContentId(userContent.getUserId(), userContent.getContentId());

        if (existingContent.isEmpty()) {
            throw new EntityNotFoundException("UserContent not found for userId: "
                    + userContent.getUserId() + " and contentId: " + userContent.getContentId());
        }

        UserContent updatedContent = existingContent.get();
        updatedContent.setStatus(userContent.getStatus());
        updatedContent.setUserRating(userContent.getUserRating());
        updatedContent.setComment(userContent.getComment());

        return userContentDAO.save(updatedContent);
    }

    @Override
    public void deleteUserContent(String userId, int contentId) {
        userContentDAO.findByUserIdAndContentId(userId,contentId)
                .ifPresent(userContentDAO :: delete);
    }
}
