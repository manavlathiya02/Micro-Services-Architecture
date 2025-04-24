package com.lcwd.user.service.service;

import com.lcwd.user.service.Model.User;

import java.util.List;

public interface UserService {

    //create new user
    User saveUser(User user);

    //get all users
    List<User>getAllUsers();

    //get single user of given userId
    User getUser(Integer UserId);

    //delete user
    void deleteById(Integer UserId);

    //update User
    User updateUserById(Integer UserId,String name);



}
