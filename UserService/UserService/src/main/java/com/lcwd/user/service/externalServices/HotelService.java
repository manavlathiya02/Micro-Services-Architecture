package com.lcwd.user.service.externalServices;

import com.lcwd.user.service.Model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping("hotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") Integer hotelId);

}
