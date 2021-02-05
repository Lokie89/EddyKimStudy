package com.example.monstudy.service.movie;

import com.example.monstudy.exception.ClientNoContentRuntimeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("secret")
@SpringBootTest
public class MovieServiceSpringBootTest {
    @Autowired
    MovieService movieService;


    @DisplayName("추천할 영화가 없을 때는 예외를 발생시키는지 검증")
    @Test
    void shouldThrowExceptionWhenNoneRecommend() {
        assertThrows(ClientNoContentRuntimeException.class, () -> movieService.recommendTodayMovie("반지의제황"));
    }
}
