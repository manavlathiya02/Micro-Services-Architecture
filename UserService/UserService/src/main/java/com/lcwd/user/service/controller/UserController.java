package com.lcwd.user.service.controller;

import com.lcwd.user.service.Model.User;
import com.lcwd.user.service.Repository.UsersRepository;
import com.lcwd.user.service.service.UserService;
import com.lcwd.user.service.service.impl.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping()
    public ResponseEntity<User>saveUser(@RequestBody User user){
      User user1= userService.saveUser(user);
      return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    @GetMapping
    public ResponseEntity<List<User>>getAllUsers(){
        List<User>users=userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    int retryCount=1;

    @GetMapping("/{userId}")
 //   @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
  //  @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter" ,fallbackMethod ="ratingHotelFallback")
    public ResponseEntity<User> getById(@PathVariable Integer userId) {
        logger.info("Retry Counter {}",retryCount);
        retryCount++;

        User user = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    public ResponseEntity<User> ratingHotelFallback(@PathVariable Integer userId, Exception ex) {
      //  logger.error("Fallback triggered for userId {} due to: {}", userId, ex.getMessage());
        User dummyUser = new User();
        dummyUser.setName("dummy");
        dummyUser.setAbout("this is dummy user");
        dummyUser.setEmail("dummy@gmail.com");
        dummyUser.setUserId(0);

        logger.info("Returning dummy user as fallback response.");
        return new ResponseEntity<>(dummyUser, HttpStatus.OK);
    }


    @DeleteMapping("/{UserId}")
    public ResponseEntity<User>DeleteById(@PathVariable Integer UserId){
        User user=userService.getUser(UserId);
          userService.deleteById(UserId);
        return  ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody String name, @PathVariable Integer userId) {
        User user = userService.getUser(userId);
        user.setName(name);
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
