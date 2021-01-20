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

    public MovieRepositoryImpl(RestTemplate restTemplate,
                               NaverProperties naverProperties) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
    }

    @Override
    public List<Movie> findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getMovieUrl() + "?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), ResponseMovieDto.class)
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
