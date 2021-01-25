package com.example.monstudy.domain.movie;

import com.example.monstudy.config.NaverProperties;
import com.example.monstudy.web.dto.ResponseMovieDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieRepositoryImpl implements MovieRepository {

    private RestTemplate restTemplate;
    private NaverProperties naverProperties;
    private HttpHeaders naverAPIHeaders;

    public MovieRepositoryImpl(RestTemplate restTemplate,
                               NaverProperties naverProperties,
                               HttpHeaders naverAPIHeaders) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
        this.naverAPIHeaders = naverAPIHeaders;
    }

    @Override
    public List<Movie> findByQuery(String query) {
        String url = naverProperties.getMovieUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(naverAPIHeaders), ResponseMovieDto.class)
                .getBody()
                .getItems()
                .stream()
                .map(m -> Movie.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .actor(m.getActor())
                        .director(m.getDirector())
                        .userRating(m.getUserRating())
                        .build())
                .collect(Collectors.toList())
                ;
    }
}
