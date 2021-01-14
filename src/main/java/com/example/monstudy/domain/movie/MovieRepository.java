package com.example.monstudy.domain.movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findByQuery(String query);
}
