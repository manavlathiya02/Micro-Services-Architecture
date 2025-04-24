package com.example.RatingService.Controllers;

import com.example.RatingService.Model.Ratings;
import com.example.RatingService.service.impl.RatingServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingServiceimpl ratingServiceimpl;

    @PostMapping
    public ResponseEntity<Ratings>crateRatings(@RequestBody Ratings ratings){
       return ResponseEntity.status(HttpStatus.CREATED).body(ratingServiceimpl.createRatings(ratings));
    }
    @GetMapping
   public ResponseEntity<List<Ratings>>getRatings(){
        return ResponseEntity.ok(ratingServiceimpl.getAllRatings());
   }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Ratings>>getRatingsByUserId(@PathVariable Integer userId){
        return ResponseEntity.ok(ratingServiceimpl.getRatingsByUserId(userId));
    }

    @GetMapping("hotels/{hotelId}")
    public ResponseEntity<List<Ratings>>getRatingsByHotelId(@PathVariable Integer hotelId){
        return ResponseEntity.ok(ratingServiceimpl.getRatingsByHotelId(hotelId));
    }





}
