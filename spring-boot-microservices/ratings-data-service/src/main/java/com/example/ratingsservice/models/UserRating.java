package com.example.ratingsservice.models;

import java.util.List;

public class UserRating {
    private List<RatingProjection> ratings;

    public UserRating() {
    }

    public UserRating(List<RatingProjection> ratings) {
        this.ratings = ratings;
    }

    public List<RatingProjection> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingProjection> ratings) {
        this.ratings = ratings;
    }
}
