package com.rest_api_java.api.services;

import com.rest_api_java.api.model.User;

import java.util.List;

public interface IUserService {

    //----------------------------------------------------------------------

    Integer addUser(User user);

    //----------------------------------------------------------------------

    List<User> getAllUsers();

    //----------------------------------------------------------------------

    User getUserById(Integer id);

    //----------------------------------------------------------------------

    void updateUser(User user);

    //----------------------------------------------------------------------

    void deleteUserById(Integer id);

    //----------------------------------------------------------------------

    void deleteAll();
}
