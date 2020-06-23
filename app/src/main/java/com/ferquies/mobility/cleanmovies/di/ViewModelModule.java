package com.ferquies.mobility.cleanmovies.di;

import androidx.lifecycle.ViewModel;

import com.ferquies.mobility.cleanmovies.ui.detail.fragment.DetailViewModel;
import com.ferquies.mobility.cleanmovies.ui.main.activity.SharedViewModel;
import com.ferquies.mobility.cleanmovies.ui.main.fragment.MainViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel.class)
    abstract ViewModel bindSharedViewModel(SharedViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindMainViewModel(MainViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel.class)
    abstract ViewModel bindDetailViewModel(DetailViewModel viewModel);
}
