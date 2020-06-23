package com.ferquies.mobility.cleanmovies.domain.mappers;

import com.ferquies.mobility.cleanmovies.domain.entity.api.SearchResultApi;
import com.ferquies.mobility.cleanmovies.domain.entity.api.SearchResultItemApi;
import com.ferquies.mobility.cleanmovies.domain.entity.model.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SearchResultMapper implements Mapper<Movie, SearchResultItemApi> {

    @Inject
    public SearchResultMapper() {
    }

    @Override
    public Movie map(SearchResultItemApi entity) {
        Movie model = new Movie();
        model.setTitle(entity.getTitle());
        model.setYear(entity.getYear());
        model.setType(entity.getType());
        model.setPoster(entity.getPoster());
        model.setImdbID(entity.getImdbID());

        return model;
    }

    public List<Movie> map(SearchResultApi searchResultApi) {
        List<Movie> model = new ArrayList<>();

        for (SearchResultItemApi entity : searchResultApi.getSearch()) {
            model.add(map(entity));
        }

        return model;
    }
}
