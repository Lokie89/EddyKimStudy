package com.example.monstudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "naver.openapi")
public class NaverProperties {
    private String movieUrl;
    private String newsUrl;
    private String clientId;
    private String clientSecret;
}
