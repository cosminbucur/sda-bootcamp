package com.sda.ratings.model;

import javax.persistence.*;

@Entity(name = "Rating")
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ratingId;
    private int rating;

    public Rating() {
    }

    public Rating(String ratingId, int rating) {
        this.ratingId = ratingId;
        this.rating = rating;
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
