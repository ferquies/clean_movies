package com.ferquies.mobility.cleanmovies.ui.main.fragment.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ferquies.mobility.cleanmovies.R;
import com.ferquies.mobility.cleanmovies.model.entity.domain.Movie;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private Movie movie;

    private ImageView poster;
    private TextView title;

    public MovieViewHolder(@NonNull View itemView, MovieListAdapter.OnClickCallback callback) {
        super(itemView);
        poster = itemView.findViewById(R.id.movie_item_poster);
        title = itemView.findViewById(R.id.movie_item_title);
        itemView.setOnClickListener(__ -> callback.onItemClick(movie));
    }

    public void setData(Movie movie) {
        this.movie = movie;
        title.setText(movie.getTitle());
        Glide.with(itemView)
                .load(movie.getPoster())
                .centerCrop()
                .into(poster);
    }
}
