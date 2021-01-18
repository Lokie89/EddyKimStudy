package com.example.monstudy.service.news;

import com.example.monstudy.domain.news.News;
import com.example.monstudy.domain.news.NewsGroup;
import com.example.monstudy.domain.news.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepositoryImpl) {
        this.newsRepository = newsRepositoryImpl;
    }

    public List<News> query(String query) {
        NewsGroup newsGroup = new NewsGroup(newsRepository.findByQuery(query));
        return newsGroup.getListOrderRating();
    }
}
