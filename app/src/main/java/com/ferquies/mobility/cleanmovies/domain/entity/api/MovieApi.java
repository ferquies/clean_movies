package com.ferquies.mobility.cleanmovies.model.entity.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieApi implements Serializable {
    private static final long serialVersionUID = 2384179560892194958L;

    @SerializedName("Ratings")
    List<RatingApi> ratings;
    @SerializedName("Title")
    String title;
    @SerializedName("Year")
    String year;
    @SerializedName("Rated")
    String rated;
    @SerializedName("Released")
    String released;
    @SerializedName("Runtime")
    String runtime;
    @SerializedName("Genre")
    String genre;
    @SerializedName("Director")
    String director;
    @SerializedName("Writer")
    String writer;
    @SerializedName("Actors")
    String actors;
    @SerializedName("Plot")
    String plot;
    @SerializedName("Language")
    String language;
    @SerializedName("Country")
    String country;
    @SerializedName("Awards")
    String awards;
    @SerializedName("Poster")
    String poster;
    @SerializedName("Metascore")
    String metascore;
    @SerializedName("imdbRating")
    String imdbRating;
    @SerializedName("imdbVotes")
    String imdbVotes;
    @SerializedName("imdbID")
    String imdbID;
    @SerializedName("Type")
    String type;
    @SerializedName("DVD")
    String dvd;
    @SerializedName("BoxOffice")
    String boxOffice;
    @SerializedName("Production")
    String production;
    @SerializedName("Website")
    String website;
    @SerializedName("Response")
    String response;

    public List<RatingApi> getRatings() {
        return ratings;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getDvd() {
        return dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public String getWebsite() {
        return website;
    }

    public String getResponse() {
        return response;
    }
}