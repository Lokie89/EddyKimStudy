package com.example.monstudy.domain.movie;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class MovieGroup {
    private final List<Movie> list;

    public MovieGroup(List<Movie> list) {
        this.list = list;
    }

    public MovieGroup getMovieGroupOrderRating() {
        return new MovieGroup(list.stream()
                .sorted(Comparator.comparing(Movie::getUserRating).reversed())
                .collect(Collectors.toList()));
    }

    public MovieGroup getMovieGroupFilterZero() {
        return new MovieGroup(list.stream()
                .filter(m -> m.getUserRating() > 0)
                .collect(Collectors.toList()));
    }

    public Optional<Movie> getHighestRatingMovie(){
        return getMovieGroupOrderRating().getList().stream().findFirst();
    }
}
