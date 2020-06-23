package com.ferquies.mobility.cleanmovies.ui.main.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ferquies.mobility.cleanmovies.App;
import com.ferquies.mobility.cleanmovies.R;
import com.ferquies.mobility.cleanmovies.model.base.BaseFragment;
import com.ferquies.mobility.cleanmovies.model.state.State;
import com.ferquies.mobility.cleanmovies.model.entity.domain.Movie;
import com.ferquies.mobility.cleanmovies.ui.main.activity.SharedViewModel;
import com.ferquies.mobility.cleanmovies.ui.main.fragment.adapter.MovieListAdapter;

import java.util.List;

import javax.inject.Inject;

public class MainFragment extends BaseFragment<MainViewModel> {

    @Inject
    MovieListAdapter adapter;

    private SharedViewModel sharedViewModel;

    private TextView message;
    private RecyclerView moviesList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
        bindViews(view);
        configureViews();
        viewModel().getState().observe(this, this::render);
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        viewModel().init();
    }

    private void inject() {
        ((App) requireActivity().getApplication()).getAppComponent().inject(this);
    }

    private void bindViews(View view) {
        message = view.findViewById(R.id.main_message);
        moviesList = view.findViewById(R.id.main_moviesList);
    }

    private void configureViews() {
        adapter.setCallback(movie -> {
            viewModel().onItemClick(movie);
            NavDirections action = MainFragmentDirections.actionMainFragmentToDetailFragment(movie);
            sharedViewModel.navigateTo(action);
        });

        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 3);
        moviesList.setHasFixedSize(true);
        moviesList.setLayoutManager(layoutManager);
        moviesList.setAdapter(adapter);
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected void render(State state) {
        if (state instanceof State.Loading) {
            sharedViewModel.showLoading();
        } else {
            sharedViewModel.hideLoading();
        }

        if (state instanceof State.Error) {
            sharedViewModel.showError(((State.Error) state).getError());
        }

        if (state instanceof State.NoContent) {
            message.setText(R.string.no_content);
            message.setVisibility(View.VISIBLE);
            moviesList.setVisibility(View.GONE);
        }

        if (state instanceof State.Content) {
            adapter.setData(((State.Content<List<Movie>>) state).getContent());
            message.setVisibility(View.GONE);
            moviesList.setVisibility(View.VISIBLE);
        }

        Log.d("MainFragment", "render: " + state.toString());
    }
}