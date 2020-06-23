package com.ferquies.mobility.cleanmovies;

import android.app.Application;

import com.ferquies.mobility.cleanmovies.di.AppComponent;
import com.ferquies.mobility.cleanmovies.di.DaggerAppComponent;

public class App extends Application {
    AppComponent appComponent = DaggerAppComponent.create();

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
