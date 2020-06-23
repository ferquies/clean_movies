package com.ferquies.mobility.cleanmovies.domain.base;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.ferquies.mobility.cleanmovies.domain.state.State;

import javax.inject.Inject;

public abstract class BaseFragment<VM extends BaseViewModel> extends Fragment {
    @Inject
    ViewModelProvider.Factory factory;

    protected VM viewModel() {
        return ViewModelProviders.of(this, factory).get(getViewModelClass());
    }

    protected abstract Class<VM> getViewModelClass();

    protected abstract void render(State state);
}
