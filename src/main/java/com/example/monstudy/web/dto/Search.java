package com.example.monstudy.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(exclude = "searchTime")
@Getter
@RequiredArgsConstructor
public class Search {
    private final String keyword;
    private final LocalDateTime searchTime;
}
