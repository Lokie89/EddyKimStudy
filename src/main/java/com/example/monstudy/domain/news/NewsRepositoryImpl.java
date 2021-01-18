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

    public NewsRepositoryImpl(RestTemplate restTemplate,
                              NaverProperties naverProperties) {
        this.restTemplate = restTemplate;
        this.naverProperties = naverProperties;
    }

    @Override
    public List<News> findByQuery(String query) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", naverProperties.getClientId());
        httpHeaders.add("X-Naver-Client-Secret", naverProperties.getClientSecret());

        String url = naverProperties.getNewsUrl() + "?query=" + query;
        return restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), ResponseNewsDto.class)
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
