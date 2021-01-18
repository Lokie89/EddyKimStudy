package com.example.monstudy.domain.news;

import java.util.List;

public interface NewsRepository {
    List<News> findByQuery(String query);
}
