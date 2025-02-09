package com.spring_demo.watch_list.dto;

import com.spring_demo.watch_list.entity.ContentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContentRequest {
    private int contentId;
    private ContentStatus status;
    private Double userRating;
    private String comment;
}
