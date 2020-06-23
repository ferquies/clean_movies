package com.ferquies.mobility.cleanmovies.domain.repository;

import com.ferquies.mobility.cleanmovies.domain.entity.model.Movie;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface Repository {
    Single<Movie> findMovie(String text);

    Single<List<Movie>> search(String text);
}
