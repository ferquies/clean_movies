package com.ferquies.mobility.cleanmovies.ui.main.fragment;

import android.util.Log;

import com.ferquies.mobility.cleanmovies.model.base.BaseViewModel;
import com.ferquies.mobility.cleanmovies.model.base.state.State;
import com.ferquies.mobility.cleanmovies.model.entity.domain.Movie;
import com.ferquies.mobility.cleanmovies.model.usecases.SearchUseCase;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel {

    private SearchUseCase searchUseCase;

    @Inject
    public MainViewModel(SearchUseCase searchUseCase) {
        this.searchUseCase = searchUseCase;
    }

    public void init() {
        if (state.getState() instanceof State.Content) {
            return;
        }

        state.update(new State.NoContent());

        SearchUseCase.Params params = new SearchUseCase.Params("clean");

        addDisposable(
                searchUseCase.execute(params)
                        .doOnSubscribe(__ -> state.update(new State.Loading()))
                        .subscribe(
                                response -> state.update(new State.Content<>(response)),
                                error -> state.update(new State.Error(error.getMessage()))
                        )
        );
    }

    public void onItemClick(Movie movie) {
        Log.d("MainViewModel", movie.getTitle());
    }
}