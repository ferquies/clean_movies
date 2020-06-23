package com.ferquies.mobility.cleanmovies.di;

import com.ferquies.mobility.cleanmovies.ui.detail.fragment.DetailFragment;
import com.ferquies.mobility.cleanmovies.ui.main.activity.MainActivity;
import com.ferquies.mobility.cleanmovies.ui.main.fragment.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, RepositoryModule.class, ViewModelFactoryModule.class, ViewModelModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    void inject(MainFragment mainFragment);

    void inject(DetailFragment detailFragment);
}
