package com.example.monstudy.web;

import com.example.monstudy.service.movie.MovieService;
import com.example.monstudy.web.dto.UpdateSearchResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/manage")
@RestController
public class ManageController {
    private MovieService movieService;

    public ManageController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/updateSearchMovie")
    public List<UpdateSearchResponseDto> updateSearchMovie() {
        return movieService.updateAllSearch();
    }
}
