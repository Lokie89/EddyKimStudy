package com.example.monstudy.domain.movie;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MovieGroup {
    private final List<Movie> list;

    public MovieGroup(List<Movie> list) {
        this.list = list;
    }

    public List<Movie> getListOrderRating() {
        return list.stream()
                .filter(b->b.getUserRating()>0)
                .sorted(Comparator.comparing(Movie::getUserRating).reversed())
                .collect(Collectors.toList());
    }
}
