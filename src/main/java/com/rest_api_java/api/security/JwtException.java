package com.rest_api_java.api.security;

import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.HttpStatus;

public class JwtException extends UnsupportedJwtException {

    //----------------------------------------------------------------------
    //Attributes
    //----------------------------------------------------------------------

    private HttpStatus httpStatus;

    //----------------------------------------------------------------------
    //Constructor
    //----------------------------------------------------------------------

    public JwtException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
    //----------------------------------------------------------------------
    //Methods
    //----------------------------------------------------------------------

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    //----------------------------------------------------------------------

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
