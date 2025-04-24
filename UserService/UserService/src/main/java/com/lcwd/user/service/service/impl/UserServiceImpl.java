package com.lcwd.user.service.service.impl;

import com.lcwd.user.service.Model.Hotel;
import com.lcwd.user.service.Model.Rating;
import com.lcwd.user.service.Model.User;
import com.lcwd.user.service.Repository.UsersRepository;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.externalServices.HotelService;
import com.lcwd.user.service.service.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);



    @Override
    public User saveUser(User user) {
        return usersRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }


    @Override
    public User getUser(Integer userId) {
        User user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User with the given ID was not found on the server"));

        Rating[] ratingsArray = restTemplate.getForObject(
                "http://RATINGSERVICE/ratings/users/" + user.getUserId(),
                Rating[].class
        );

        List<Rating> ratings = List.of(ratingsArray);

        logger.info("Fetched ratings from Rating Service: {}", ratings);

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get hotel
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRating(ratingList);

        return user;
    }

    // Fallback method for when RATINGSERVICE is down


    @Override
    public void deleteById(Integer userId) {
        if (!usersRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User with the given ID was not found for deletion");
        }
        usersRepository.deleteById(userId);
    }

    @Override
    public User updateUserById(Integer userId, String name) {
        User user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with the given ID was not found for update"));
        user.setName(name);
        return usersRepository.save(user);
    }
}
