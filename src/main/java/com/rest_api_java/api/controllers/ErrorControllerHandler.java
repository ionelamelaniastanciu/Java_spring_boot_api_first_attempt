package com.rest_api_java.api.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorControllerHandler implements ErrorController {

    @GetMapping("/error")
    public String error() {

        return "Something is missing!";
    }

}
