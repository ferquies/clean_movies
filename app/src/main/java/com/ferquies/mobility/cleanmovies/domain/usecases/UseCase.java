package com.ferquies.mobility.cleanmovies.domain.usecases;

import com.ferquies.mobility.cleanmovies.domain.repository.Repository;

@SuppressWarnings("rawtypes")
public abstract class UseCase<T, P extends UseCase.Params> {
    protected Repository repository;

    public UseCase(Repository repository) {
        this.repository = repository;
    }

    public abstract T execute(P params);

    public abstract static class Params<PT> {
        private PT params;

        public Params(PT params) {
            this.params = params;
        }

        public PT getParams() {
            return params;
        }
    }
}
