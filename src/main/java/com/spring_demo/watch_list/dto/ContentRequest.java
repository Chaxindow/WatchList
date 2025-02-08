package com.spring_demo.watch_list.dto;

import com.spring_demo.watch_list.entity.ContentType;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
public class ContentRequest {
    private String title;
    private ContentType type;
    private double imdbRating;
    private List<Integer> categoryIds;
}
