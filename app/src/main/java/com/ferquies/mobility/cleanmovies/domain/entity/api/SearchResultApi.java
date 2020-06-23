package com.ferquies.mobility.cleanmovies.domain.entity.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchResultApi implements Serializable {
    private static final long serialVersionUID = 4414097691485225168L;

    @SerializedName("Search")
    List<SearchResultItemApi> search;
    @SerializedName("totalResults")
    String totalResults;
    @SerializedName("Response")
    String response;
    @SerializedName("Error")
    String error;

    public List<SearchResultItemApi> getSearch() {
        return search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public String getResponse() {
        return response;
    }

    public String getError() {
        return error == null ? "" : error;
    }
}
