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

//    @Cacheable(value = "cache::movies")
    public List<Movie> search(String query) {
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        return movieGroup.getMovieGroupOrderRating().getList();
    }
}
