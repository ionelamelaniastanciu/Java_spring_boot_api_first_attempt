package com.rest_api_java.api.services;

import com.rest_api_java.api.model.User;
import com.rest_api_java.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    @Autowired
    private UserRepository userRepository;

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    @Override
    public Integer addUser(User user) {

        Optional<User> users = userRepository.findById(user.getId());

        if (users.isPresent() && users.get().getEmail().equalsIgnoreCase(user.getEmail()))
            return null;
        else
            return userRepository.save(user).getId();
    }

    //----------------------------------------------------------------------

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    //----------------------------------------------------------------------

    @Override
    public User getUserById(Integer id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            return null;
        else
            return user.get();
    }

    //----------------------------------------------------------------------

    @Override
    public void deleteUserById(Integer id) {

        userRepository.deleteById(id);
    }

    //----------------------------------------------------------------------

    @Override
    public void deleteAll() {

        userRepository.deleteAll();
    }

    //----------------------------------------------------------------------

    @Override
    public void updateUser(User user) {

        userRepository.save(user);
    }
}
