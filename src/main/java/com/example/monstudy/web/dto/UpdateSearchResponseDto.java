package com.example.monstudy.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateSearchResponseDto {
    private String keyword;
    private int updateCount;
}
