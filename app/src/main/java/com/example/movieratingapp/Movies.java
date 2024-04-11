package com.example.movieratingapp;

public class Movies {
    private String title,poster,overview,type;
    private Double rating;
    Movies(String title,String poster,String overview,Double rating,String type){
        this.title=title;
        this.poster=poster;
        this.overview=overview;
        this.rating=rating;
        this.type=type;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public String getType() {
        return type;
    }
}
