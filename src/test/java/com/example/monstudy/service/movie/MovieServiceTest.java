package com.example.monstudy.service.movie;

import com.example.monstudy.domain.movie.Movie;
import com.example.monstudy.domain.movie.MovieGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @DisplayName("평점 순으로 정렬되는지")
    @Test
    void shouldSortedInOrderOfGrade(){
        Movie movie1 = Movie.builder().title("평점2.3").userRating(2.3F).build();
        Movie movie2 = Movie.builder().title("평점2.1").userRating(2.1F).build();
        Movie movie3 = Movie.builder().title("평점3.0").userRating(3.0F).build();
        Movie movie4 = Movie.builder().title("평점5.1").userRating(5.1F).build();
        Movie movie5 = Movie.builder().title("평점1.7").userRating(1.7F).build();
        List<Movie> movieList = new ArrayList<>();

        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);
        movieList.add(movie5);

        MovieGroup movieGroup = new MovieGroup(movieList);

        assertEquals(movieGroup.getList().get(0).getUserRating(),2.3F);

        MovieGroup orderedGroup = new MovieGroup(movieGroup.getListOrderRating());
        assertEquals(orderedGroup.getList().get(0).getUserRating(),5.1F);
    }
}