package com.example.monstudy.web;

import com.example.monstudy.config.NaverProperties;
import com.example.monstudy.domain.movie.Movie;
import com.example.monstudy.domain.news.News;
import com.example.monstudy.service.movie.MovieService;
import com.example.monstudy.service.news.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    private MovieService movieService;
    private NewsService newsService;
    private NaverProperties naverProperties;

    public SearchController(MovieService movieService,
                            NewsService newsService,
                            NaverProperties naverProperties) {
        this.movieService = movieService;
        this.newsService = newsService;
        this.naverProperties = naverProperties;
    }

    @GetMapping("/movies")
    public List<Movie> getMoviesByQuery(@RequestParam(name = "q") String query) {
        return movieService.search(query);
    }

    @GetMapping("/news")
    public List<News> getNewsByQuery(@RequestParam(name = "q") String query) {
        return newsService.query(query);
    }
}
