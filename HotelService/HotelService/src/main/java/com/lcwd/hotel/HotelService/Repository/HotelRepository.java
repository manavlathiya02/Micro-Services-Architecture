package com.lcwd.hotel.HotelService.Repository;

import com.lcwd.hotel.HotelService.Model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,Integer> {
}
