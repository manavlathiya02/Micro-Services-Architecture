package com.lcwd.hotel.HotelService.service;

import com.lcwd.hotel.HotelService.Model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel>getAllHotel();
   Hotel getById(Integer id);
}
