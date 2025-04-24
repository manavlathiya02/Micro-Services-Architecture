package com.lcwd.hotel.HotelService.service;

import com.lcwd.hotel.HotelService.Model.Hotel;
import com.lcwd.hotel.HotelService.Repository.HotelRepository;
import com.lcwd.hotel.HotelService.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(Integer id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found exception"));
    }
}
