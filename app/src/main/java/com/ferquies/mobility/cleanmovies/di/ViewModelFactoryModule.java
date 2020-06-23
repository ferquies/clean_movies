package com.ferquies.mobility.cleanmovies.di;

import androidx.lifecycle.ViewModelProvider;

import com.ferquies.mobility.cleanmovies.model.util.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelFactoryModule {
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory factory) {
        return factory;
    }
}
