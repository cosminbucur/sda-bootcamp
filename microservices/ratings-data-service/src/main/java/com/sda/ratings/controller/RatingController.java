package com.sda.ratings.controller;

import com.sda.ratings.model.Rating;
import com.sda.ratings.model.UserRatings;
import com.sda.ratings.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/ratings")
@RestController
public class RatingController {

    public RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 5);
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Rating> rate(@PathVariable("userId") String userId, @RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.save(userId, rating), HttpStatus.CREATED);
    }

    // avoid returning lists in APIs, in case we make changes
    @GetMapping("/users/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1111", 5),
                new Rating("2222", 4)
        );
        UserRatings userRatings = new UserRatings();
        userRatings.setRatings(ratings);
        return userRatings;
    }
}
