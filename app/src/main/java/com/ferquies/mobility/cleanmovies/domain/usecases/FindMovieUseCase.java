package com.ferquies.mobility.cleanmovies.model.usecases;

import com.ferquies.mobility.cleanmovies.model.entity.domain.Movie;
import com.ferquies.mobility.cleanmovies.model.repository.Repository;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FindMovieUseCase extends UseCase<Single<Movie>, FindMovieUseCase.Params> {

    @Inject
    public FindMovieUseCase(Repository repository) {
        super(repository);
    }

    @Override
    public Single<Movie> execute(Params params) {
        return repository.findMovie(params.getParams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static class Params extends UseCase.Params<String> {
        public Params(String params) {
            super(params);
        }
    }
}
