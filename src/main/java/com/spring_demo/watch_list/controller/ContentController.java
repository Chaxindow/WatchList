package com.spring_demo.watch_list.controller;

import com.spring_demo.watch_list.dto.ContentRequest;
import com.spring_demo.watch_list.entity.Content;
import com.spring_demo.watch_list.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping
    public ResponseEntity<List<Content>> getAllContents() {
        List<Content> contents = contentService.getAllContents();
        return ResponseEntity.ok(contents); // 200 OK
    }

    @PostMapping
    public ResponseEntity<Content> addContent(@RequestBody Content content) {
        Content savedContent = contentService.addContent(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContent); // 201 Created
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable int id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @PostMapping("/with-categories")
    public ResponseEntity<Content> saveContentWithCategories(@RequestBody ContentRequest contentRequest) {
        Content content = new Content();
        content.setTitle(contentRequest.getTitle());
        content.setType(contentRequest.getType());
        content.setImdbRating(contentRequest.getImdbRating());

        Content savedContent = contentService.saveContentWithCategories(content, contentRequest.getCategoryIds());

        return ResponseEntity.status(HttpStatus.CREATED).body(savedContent);
    }


}
