package com.example.RatingService.service;

import com.example.RatingService.Model.Ratings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingsService {
    Ratings createRatings(Ratings ratings);
    List<Ratings>getAllRatings();
    List<Ratings>getRatingsByUserId(Integer userId);
    List<Ratings>getRatingsByHotelId(Integer houseId);


}
