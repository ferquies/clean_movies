package com.ferquies.mobility.cleanmovies.ui.main.fragment;

import android.util.Log;

import com.ferquies.mobility.cleanmovies.domain.base.BaseViewModel;
import com.ferquies.mobility.cleanmovies.domain.state.State;
import com.ferquies.mobility.cleanmovies.domain.entity.domain.Movie;
import com.ferquies.mobility.cleanmovies.domain.usecases.SearchUseCase;

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