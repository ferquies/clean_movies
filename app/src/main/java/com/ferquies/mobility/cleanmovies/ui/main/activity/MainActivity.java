package com.ferquies.mobility.cleanmovies.ui.main.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.ferquies.mobility.cleanmovies.App;
import com.ferquies.mobility.cleanmovies.R;
import com.ferquies.mobility.cleanmovies.model.base.BaseActivity;
import com.ferquies.mobility.cleanmovies.model.state.State;

public class MainActivity extends BaseActivity<SharedViewModel> {

    private FrameLayout loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        inject();
        bindViews();
        viewModel().getState().observe(this, this::render);
        viewModel().getNavigation().observe(this, this::navigateTo);
    }

    @Override
    protected Class<SharedViewModel> getViewModelClass() {
        return SharedViewModel.class;
    }

    @Override
    protected void render(State state) {
        loading.setVisibility(state instanceof State.Loading ? View.VISIBLE : View.GONE);

        if (state instanceof State.Error) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.error_title))
                    .setMessage(((State.Error) state).getError())
                    .setNegativeButton(R.string.accept, null)
                    .show();
        }

        Log.d("MainActivity", "render: " + state.toString());
    }

    private void inject() {
        ((App) getApplication()).getAppComponent().inject(this);
    }

    private void bindViews() {
        loading = findViewById(R.id.loading);
    }

    private void navigateTo(NavDirections action) {
        Navigation.findNavController(this, R.id.nav_host_fragment).navigate(action);
    }
}