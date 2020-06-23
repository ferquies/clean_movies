package com.ferquies.mobility.cleanmovies.model.base.state;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

public class ViewState {
    protected State state;

    private MutableLiveData<State> mutableLiveData = new MutableLiveData<>();

    public ViewState(State state) {
        update(state);
    }

    public void update(State state) {
        if (this.state != null && this.state.equals(state)) {
            return;
        }

        this.state = state;
        mutableLiveData.setValue(state);
    }

    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<State> observer) {
        mutableLiveData.observe(owner, observer);
    }

    public State getState() {
        return state;
    }
}
