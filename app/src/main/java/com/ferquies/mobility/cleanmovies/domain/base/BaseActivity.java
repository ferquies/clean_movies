package com.ferquies.mobility.cleanmovies.model.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.ferquies.mobility.cleanmovies.model.state.State;

import javax.inject.Inject;

@SuppressWarnings("rawtypes")
public abstract class BaseActivity<VM extends BaseViewModel> extends AppCompatActivity {
    @Inject
    ViewModelProvider.Factory factory;

    protected VM viewModel() {
        return ViewModelProviders.of(this, factory).get(getViewModelClass());
    }

    protected abstract Class<VM> getViewModelClass();

    protected abstract void render(State state);
}
