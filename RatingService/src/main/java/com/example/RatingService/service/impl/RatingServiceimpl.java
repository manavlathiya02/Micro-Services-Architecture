package com.example.RatingService.service.impl;

import com.example.RatingService.Model.Ratings;
import com.example.RatingService.repository.RatingRepository;
import com.example.RatingService.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceimpl implements RatingsService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Ratings createRatings(Ratings ratings) {
        return ratingRepository.save(ratings);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> getRatingsByUserId(Integer userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getRatingsByHotelId(Integer houseId) {
        return ratingRepository.findByHotelId(houseId);
    }
}
