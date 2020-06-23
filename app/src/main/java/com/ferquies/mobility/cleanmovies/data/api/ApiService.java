package com.ferquies.mobility.cleanmovies.data.api;

import com.ferquies.mobility.cleanmovies.domain.entity.api.MovieApi;
import com.ferquies.mobility.cleanmovies.domain.entity.api.SearchResultApi;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/")
    Single<MovieApi> findMovie(@Query("t") String text);

    @GET("/")
    Single<SearchResultApi> search(@Query("s") String text);
}
