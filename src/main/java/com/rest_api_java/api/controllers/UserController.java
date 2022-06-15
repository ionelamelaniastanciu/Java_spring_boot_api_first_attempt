package com.rest_api_java.api.controllers;

import com.rest_api_java.api.model.User;
import com.rest_api_java.api.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    @Autowired
    private IUserService userService;

    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {

        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //----------------------------------------------------------------------

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //----------------------------------------------------------------------

    @RequestMapping(value = "/new", method = {RequestMethod.POST, RequestMethod.GET}, consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        User userCheck = userService.getUserById(user.getId());
        if (userCheck != null && userCheck.getEmail().equalsIgnoreCase(user.getEmail()))
            return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        else {
            userService.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    //----------------------------------------------------------------------

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {

        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //----------------------------------------------------------------------

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET}, consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> deleteArticle(@PathVariable("id") Integer id) {

        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
