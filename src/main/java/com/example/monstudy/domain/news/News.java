package com.example.monstudy.domain.news;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class News {
    private String title;
    private String link;
    private String description;
    private Date pubDate;
}
