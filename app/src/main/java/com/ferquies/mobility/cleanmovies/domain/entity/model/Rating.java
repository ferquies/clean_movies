package com.ferquies.mobility.cleanmovies.domain.entity.model;

import java.io.Serializable;

public class Rating implements Serializable {
    private static final long serialVersionUID = 3524367381933337764L;

    private String source;
    private String value;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "source='" + source + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
