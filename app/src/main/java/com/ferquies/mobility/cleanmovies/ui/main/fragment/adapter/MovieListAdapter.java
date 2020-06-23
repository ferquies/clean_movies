package com.ferquies.mobility.cleanmovies.ui.main.fragment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ferquies.mobility.cleanmovies.R;
import com.ferquies.mobility.cleanmovies.domain.entity.model.Movie;

import java.util.List;

import javax.inject.Inject;

public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private OnClickCallback callback;

    private List<Movie> data;

    @Inject
    public MovieListAdapter() {
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<Movie> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setCallback(OnClickCallback callback) {
        this.callback = callback;
    }

    public interface OnClickCallback {
        void onItemClick(Movie item);
    }
}
