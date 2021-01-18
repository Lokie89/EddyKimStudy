package com.example.monstudy.domain.news;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class NewsGroup {
    private final List<News> list;

    public NewsGroup(List<News> list) {
        this.list = list;
    }

    public List<News> getListOrderRating() {
        return list.stream()
                .sorted(Comparator.comparing(News::getPubDate))
                .collect(Collectors.toList())
                ;
    }
}
