package com.ferquies.mobility.cleanmovies.di;

import com.ferquies.mobility.cleanmovies.data.repository.RepositoryImpl;
import com.ferquies.mobility.cleanmovies.domain.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {
    @Singleton
    @Provides
    Repository provideRepository(RepositoryImpl repository) {
        return repository;
    }
}
