package com.example.monstudy.web;

import com.example.monstudy.config.NaverProperties;
import com.example.monstudy.domain.movie.Movie;
import com.example.monstudy.service.movie.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    private MovieService movieService;
    private NaverProperties naverProperties;

    public SearchController(MovieService movieService,
                            NaverProperties naverProperties) {
        this.movieService = movieService;
        this.naverProperties = naverProperties;
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam(name = "q") String query) {
        return movieService.query(query);
    }
}
