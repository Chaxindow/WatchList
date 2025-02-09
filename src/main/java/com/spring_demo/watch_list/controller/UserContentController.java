package com.spring_demo.watch_list.controller;

import com.spring_demo.watch_list.dto.UserContentRequest;
import com.spring_demo.watch_list.entity.Category;
import com.spring_demo.watch_list.entity.UserContent;
import com.spring_demo.watch_list.service.UserContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-content")
@RequiredArgsConstructor
public class UserContentController {

    private final UserContentService userContentService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserContent>> getUserContents(@PathVariable String userId) {
        List<UserContent> userContents = userContentService.getUserContents(userId);
        return ResponseEntity.ok(userContents);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<UserContent> addUserContent(@PathVariable String userId, @RequestBody UserContentRequest request) {
        UserContent userContent = new UserContent();
        userContent.setUserId(userId);
        userContent.setContentId(request.getContentId());
        userContent.setStatus(request.getStatus());
        userContent.setUserRating(request.getUserRating());
        userContent.setComment(request.getComment());

        userContentService.addUserContent(userContent);
        return ResponseEntity.ok(userContent);
    }

    @PutMapping("/{userId}/{contentId}")
    public ResponseEntity<UserContent> updateUserContent(
            @PathVariable String userId,
            @PathVariable int contentId,
            @RequestBody UserContentRequest request) {

        UserContent userContent = new UserContent();
        userContent.setUserId(userId);
        userContent.setContentId(contentId);
        userContent.setStatus(request.getStatus());
        userContent.setUserRating(request.getUserRating());
        userContent.setComment(request.getComment());

        userContentService.updateUserContent(userContent);

        return ResponseEntity.ok(userContent);
    }


    @DeleteMapping("/{userId}/{contentId}")
    public ResponseEntity<String> deleteUserContent(@PathVariable String userId, @PathVariable int contentId) {
        userContentService.deleteUserContent(userId, contentId);
        return ResponseEntity.ok("Content deleted successfully.");
    }


}
