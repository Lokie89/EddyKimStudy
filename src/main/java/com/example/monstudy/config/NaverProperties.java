package com.example.monstudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Data
@Configuration
@ConfigurationProperties(prefix = "naver.openapi")
public class NaverProperties {
    private String movieUrl;
    private String newsUrl;
    private String clientId;
    private String clientSecret;

    @Bean
    public HttpHeaders naverAPIHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Naver-Client-Id", clientId);
        httpHeaders.add("X-Naver-Client-Secret", clientSecret);
        return httpHeaders;
    }
}
