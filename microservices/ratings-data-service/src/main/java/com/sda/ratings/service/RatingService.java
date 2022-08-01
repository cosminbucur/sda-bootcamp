package com.sda.ratings.service;

import com.sda.ratings.dto.RatingMapper;
import com.sda.ratings.model.Rating;
import com.sda.ratings.repository.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private static final Logger log = LoggerFactory.getLogger(RatingService.class);
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Autowired
    public RatingService(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.ratingMapper = ratingMapper;
    }

    // CRUD

    public RatingResponse save(Long userId, Rating request) {
        log.debug("saving rating {}", request);
        Rating existingRating = ratingRepository.find(request.getTitle());

        Rating rating = ratingMapper.toEntity(request);
        Rating savedRating = ratingRepository.save(rating);
        return ratingMapper.toDto(savedRating);
    }

    public List<RatingResponse> findAll() {
        log.debug("find all ratings...");
        List<Rating> ratings = ratingRepository.findAll();
        return ratingMapper.toDto(ratings);
    }

    public RatingResponse findById(Long id) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("rating not found"));
        return ratingMapper.toDto(rating);
    }

    public List<RatingResponse> findByUser(String author) {
        List<Rating> ratings = ratingRepository.findByAuthor(author);
        return ratingMapper.toDto(ratings);
    }

    public RatingResponse update(Long id, RatingRequest request) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("rating not found"));

        updateFields(request, rating);

        Rating savedRating = ratingRepository.save(rating);

        return ratingMapper.toDto(savedRating);
    }

    private void updateFields(RatingRequest request, Rating rating) {
        rating.setTitle(request.getTitle());
        rating.setAuthor(request.getAuthor());
    }

    public void delete(Long id) {
        ratingRepository.deleteById(id);
    }
}
