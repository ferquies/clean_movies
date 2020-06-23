package com.ferquies.mobility.cleanmovies.domain.mappers;

import com.ferquies.mobility.cleanmovies.domain.entity.api.MovieApi;
import com.ferquies.mobility.cleanmovies.domain.entity.domain.Movie;

import javax.inject.Inject;

public class MovieMapper implements Mapper<Movie, MovieApi> {
    private RatingMapper ratingMapper;

    @Inject
    public MovieMapper(RatingMapper ratingMapper) {
        this.ratingMapper = ratingMapper;
    }

    @Override
    public Movie map(MovieApi entity) {
        Movie model = new Movie();
        model.setRatings(ratingMapper.map(entity.getRatings()));
        model.setTitle(entity.getTitle());
        model.setYear(entity.getYear());
        model.setType(entity.getType());
        model.setPoster(entity.getPoster());
        model.setImdbID(entity.getImdbID());
        model.setActors(entity.getActors());
        model.setAwards(entity.getAwards());
        model.setBoxOffice(entity.getBoxOffice());
        model.setCountry(entity.getCountry());
        model.setDirector(entity.getDirector());
        model.setDvd(entity.getDvd());
        model.setGenre(entity.getGenre());
        model.setImdbRating(entity.getImdbRating());
        model.setImdbVotes(entity.getImdbVotes());
        model.setLanguage(entity.getLanguage());
        model.setMetascore(entity.getMetascore());
        model.setPlot(entity.getPlot());
        model.setProduction(entity.getProduction());
        model.setRated(entity.getRated());
        model.setReleased(entity.getReleased());
        model.setRuntime(entity.getRuntime());
        model.setWebsite(entity.getWebsite());
        model.setWriter(entity.getWriter());

        return model;
    }
}
