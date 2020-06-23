package com.ferquies.mobility.cleanmovies.ui.detail.fragment;

import com.ferquies.mobility.cleanmovies.model.base.BaseViewModel;
import com.ferquies.mobility.cleanmovies.model.state.State;
import com.ferquies.mobility.cleanmovies.model.entity.domain.Movie;

import javax.inject.Inject;

public class DetailViewModel extends BaseViewModel {
    @Inject
    public DetailViewModel() {
    }

    public void init(Movie movie) {
        state.update(new State.Content<>(movie));
    }
}