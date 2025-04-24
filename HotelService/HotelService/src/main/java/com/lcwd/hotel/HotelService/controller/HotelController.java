package com.lcwd.hotel.HotelService.controller;

import com.lcwd.hotel.HotelService.Model.Hotel;
import com.lcwd.hotel.HotelService.service.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {
    @Autowired
    HotelServiceImpl hotelService;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
       return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>>getAllHotels(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel>getById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getById(id));
    }

}
