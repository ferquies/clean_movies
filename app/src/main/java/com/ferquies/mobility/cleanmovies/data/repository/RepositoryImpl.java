package com.ferquies.mobility.cleanmovies.data.repository;

import com.ferquies.mobility.cleanmovies.data.api.ApiService;
import com.ferquies.mobility.cleanmovies.domain.entity.domain.Movie;
import com.ferquies.mobility.cleanmovies.domain.mappers.MovieMapper;
import com.ferquies.mobility.cleanmovies.domain.mappers.SearchResultMapper;
import com.ferquies.mobility.cleanmovies.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class RepositoryImpl implements Repository {
    private final ApiService apiService;

    @Inject
    MovieMapper movieMapper;

    @Inject
    SearchResultMapper searchResultMapper;

    @Inject
    public RepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<Movie> findMovie(String text) {
        return apiService.findMovie(text).map(movieMapper::map);
    }

    @Override
    public Single<List<Movie>> search(String text) {
        return apiService.search(text).map(response -> {
            if (response.getError().isEmpty()) {
                return searchResultMapper.map(response);
            }

            throw new Exception(response.getError());
        });
    }
}
