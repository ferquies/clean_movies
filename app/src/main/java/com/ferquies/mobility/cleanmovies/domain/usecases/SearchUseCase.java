package com.ferquies.mobility.cleanmovies.domain.usecases;

import com.ferquies.mobility.cleanmovies.domain.entity.model.Movie;
import com.ferquies.mobility.cleanmovies.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchUseCase extends UseCase<Single<List<Movie>>, SearchUseCase.Params> {

    @Inject
    public SearchUseCase(Repository repository) {
        super(repository);
    }

    @Override
    public Single<List<Movie>> execute(SearchUseCase.Params params) {
        return repository.search(params.getParams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static class Params extends UseCase.Params<String> {
        public Params(String params) {
            super(params);
        }
    }
}
