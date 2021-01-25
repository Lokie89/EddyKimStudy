package com.example.monstudy.domain.news;

import com.example.monstudy.config.NaverProperties;
import com.example.monstudy.web.dto.ResponseNewsDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsRepositoryImpl implements NewsRepository {

    private RestTemplate restTemplate;
    private NaverProperties naverProperties;
    private HttpHeaders naverAPIHeaders;

    public NewsRepositoryImpl(RestTemplate restTemplate,
                              NaverProperties naverProperties,
                              HttpHeaders naverAPIHeaders) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
        this.naverAPIHeaders = naverAPIHeaders;
    }

    @Override
    public List<News> findByQuery(String query) {
        String url = naverProperties.getNewsUrl() + "?query=" + query;
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(naverAPIHeaders), ResponseNewsDto.class)
                .getBody()
                .getItems()
                .stream()
                .map(m -> News.builder()
                        .title(m.getTitle())
                        .link(m.getLink())
                        .description(m.getDescription())
                        .pubDate(m.getPubDate())
                        .build())
                .collect(Collectors.toList())
                ;
    }
}
