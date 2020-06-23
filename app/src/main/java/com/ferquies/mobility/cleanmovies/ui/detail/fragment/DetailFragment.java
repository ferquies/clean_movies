package com.ferquies.mobility.cleanmovies.ui.detail.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.ferquies.mobility.cleanmovies.App;
import com.ferquies.mobility.cleanmovies.R;
import com.ferquies.mobility.cleanmovies.domain.base.BaseFragment;
import com.ferquies.mobility.cleanmovies.domain.state.State;
import com.ferquies.mobility.cleanmovies.domain.entity.model.Movie;
import com.ferquies.mobility.cleanmovies.ui.main.activity.SharedViewModel;

public class DetailFragment extends BaseFragment<DetailViewModel> {

    private ImageView header;
    private TextView title;

    private SharedViewModel sharedViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
        bindViews(view);
        viewModel().getState().observe(this, this::render);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        viewModel().init(DetailFragmentArgs.fromBundle(requireArguments()).getMovie());
    }

    @Override
    protected Class<DetailViewModel> getViewModelClass() {
        return DetailViewModel.class;
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

        if (state instanceof State.Content) {
            Movie movie = ((State.Content<Movie>) state).getContent();
            Glide.with(this)
                    .load(movie.getPoster())
                    .centerCrop()
                    .into(header);
            title.setText(movie.getTitle());
        }
    }

    private void inject() {
        ((App) requireActivity().getApplication()).getAppComponent().inject(this);
    }

    private void bindViews(View view) {
        header = view.findViewById(R.id.detail_header);
        title = view.findViewById(R.id.detail_title);
    }
}