package com.ferquies.mobility.cleanmovies.ui.main.activity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;

import com.ferquies.mobility.cleanmovies.domain.base.BaseViewModel;
import com.ferquies.mobility.cleanmovies.domain.state.State;

import javax.inject.Inject;

public class SharedViewModel extends BaseViewModel {
    private MutableLiveData<NavDirections> navigation = new MutableLiveData<>();

    @Inject
    public SharedViewModel() {
    }

    public void showLoading() {
        state.update(new State.Loading());
    }

    public void hideLoading() {
        state.update(new State.NoContent());
    }

    public void showError(String error) {
        state.update(new State.Error(error));
    }

    public LiveData<NavDirections> getNavigation() {
        return navigation;
    }

    public void navigateTo(NavDirections action) {
        navigation.setValue(action);
    }
}
