package com.sda.ratings.dto;

import com.sda.ratings.model.Rating;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RatingMapper {

    public List<RatingResponse> toDto(List<Rating> ratings) {
        return ratings.stream()       // convert list to stream
                .map(this::toDto)   // convert entity to dto
                .collect(Collectors.toList());  // convert stream to list
    }

    public RatingResponse toDto(Rating rating) {
        RatingResponse dto = new RatingResponse();
        dto.setId(rating.getId());
        dto.setTitle(rating.getTitle());
        dto.setAuthor(rating.getAuthor());
        return dto;
    }

    public List<Rating> toEntity(List<RatingRequest> ratingRequests) {
        List<Rating> ratings = new ArrayList<>();
        for (RatingRequest ratingRequest : ratingRequests) {
            ratings.add(toEntity(ratingRequest));
        }
        return ratings;
    }

    public Rating toEntity(RatingRequest ratingRequest) {
        Rating entity = new Rating();
        entity.setTitle(ratingRequest.getTitle());
        entity.setAuthor(ratingRequest.getAuthor());
        return entity;
    }

}
