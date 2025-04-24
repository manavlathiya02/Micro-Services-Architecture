package com.example.RatingService.repository;

import com.example.RatingService.Model.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Ratings,Integer> {
    List<Ratings>findByUserId(Integer userId);
    List<Ratings>findByHotelId(Integer hotelId);

}
