package com.example.monstudy.domain.movie;

import com.example.monstudy.config.NaverProperties;
import com.example.monstudy.exception.ClientAuthRuntimeException;
import com.example.monstudy.exception.ClientBadRequestRuntimeException;
import com.example.monstudy.exception.ClientRuntimeException;
import com.example.monstudy.exception.ExceptionMessage;
import com.example.monstudy.web.dto.ResponseMovieDto;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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

        try {
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
        } catch (HttpClientErrorException ex) {
            if (HttpStatus.UNAUTHORIZED.equals(ex.getStatusCode())) {
                throw new ClientAuthRuntimeException(ExceptionMessage.NAVER_API_UNAUTHORIZED);
            } else if (HttpStatus.BAD_REQUEST.equals(ex.getStatusCode())) {
                throw new ClientBadRequestRuntimeException(ExceptionMessage.NAVER_API_BAD_REQUEST);
            } else {
                throw new ClientRuntimeException(ex.getMessage());
            }
        } catch (RuntimeException ex) {
            throw new ClientRuntimeException(ex.getMessage());
        }
    }
}
