package com.example.monstudy.service.movie;

import com.example.monstudy.domain.movie.Movie;
import com.example.monstudy.domain.movie.MovieGroup;
import com.example.monstudy.domain.movie.MovieRepository;
import com.example.monstudy.exception.ClientNoContentRuntimeException;
import com.example.monstudy.web.dto.Search;
import com.example.monstudy.web.dto.UpdateSearchResponseDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    private final Map<Search, MovieGroup> searchCache = new HashMap<>();

    public MovieService(MovieRepository movieRepositoryImpl) {
        this.movieRepository = movieRepositoryImpl;
    }

    //    @Cacheable(value = "cache::movies")
    public List<Movie> search(String query) {
        Search search = new Search(query, LocalDateTime.now());
        if (searchCache.containsKey(search)) {
            System.out.println("캐시에서 꺼냄");
            return searchCache.get(search).getMovieGroupOrderRating().getList();
        }
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        searchCache.put(search, movieGroup);
        return movieGroup.getMovieGroupOrderRating().getList();
    }

    public Movie recommendTodayMovie(String query) {
        Search search = new Search(query, LocalDateTime.now());
//        Movie defaultMovie = Movie.builder().title("기본영화").link("https://").userRating(9.9f).build();
        if (searchCache.containsKey(search)) {
            System.out.println("캐시에서 꺼냄");
            return searchCache.get(search).getHighestRatingMovie().orElseThrow(ClientNoContentRuntimeException::new);
        }
        MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(query));
        searchCache.put(search, movieGroup);
        return movieGroup.getHighestRatingMovie().orElseThrow(ClientNoContentRuntimeException::new);
    }

    public List<UpdateSearchResponseDto> updateAllSearch() {
        List<UpdateSearchResponseDto> updateSearchResponseDtos = new ArrayList<>();
        for (Search search : searchCache.keySet()) {
//            searchCache.remove(search);
            String keyword = search.getKeyword();

            MovieGroup movieGroup = new MovieGroup(movieRepository.findByQuery(keyword));
            searchCache.put(search, movieGroup);
            List<Movie> searchMovieList = movieGroup.getMovieGroupOrderRating().getList();

            updateSearchResponseDtos.add(
                    UpdateSearchResponseDto.builder()
                            .updateCount(searchMovieList.size())
                            .keyword(keyword)
                            .build()
            );
        }
        return updateSearchResponseDtos;
    }
}
