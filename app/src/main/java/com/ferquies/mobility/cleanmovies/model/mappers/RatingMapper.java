package com.ferquies.mobility.cleanmovies.model.mappers;

import com.ferquies.mobility.cleanmovies.model.entity.api.RatingApi;
import com.ferquies.mobility.cleanmovies.model.entity.domain.Rating;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RatingMapper implements Mapper<Rating, RatingApi> {

    @Inject
    public RatingMapper() {
    }

    @Override
    public Rating map(RatingApi entity) {
        Rating model = new Rating();
        model.setSource(entity.getSource());
        model.setValue(entity.getValue());

        return model;
    }

    public List<Rating> map(List<RatingApi> list) {
        List<Rating> modelList = new ArrayList<>();

        for (RatingApi entity : list) {
            modelList.add(map(entity));
        }

        return modelList;
    }
}
