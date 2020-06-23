package com.ferquies.mobility.cleanmovies.model.entity.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RatingApi implements Serializable {
    private static final long serialVersionUID = 6776139519490572366L;

    @SerializedName("Source")
    String source;
    @SerializedName("Value")
    String value;

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }
}
