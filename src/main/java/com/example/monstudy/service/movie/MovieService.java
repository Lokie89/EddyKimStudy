package com.example.monstudy.service.movie;

import com.example.monstudy.domain.movie.Movie;
import com.example.monstudy.domain.movie.MovieGroup;
import com.example.monstudy.domain.movie.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepositoryImpl) {
        this.movieRepository = movieRepositoryImpl;
    }

    public List<Movie> query(String query) {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getListOrderRating();
    }
}
