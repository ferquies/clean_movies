package com.ferquies.mobility.cleanmovies.model.base;

import androidx.lifecycle.ViewModel;

import com.ferquies.mobility.cleanmovies.model.base.state.ViewState;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

public class BaseViewModel extends ViewModel {
    protected ViewState state = new ViewState(null);

    private List<Disposable> disposables = new ArrayList<>();

    public ViewState getState() {
        return state;
    }

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    @Override
    protected void onCleared() {
        for (Disposable disposable : disposables) {
            disposable.dispose();
        }

        super.onCleared();
    }
}
