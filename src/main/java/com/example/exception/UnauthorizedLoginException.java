package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedLoginException extends RuntimeException{
    /**
     * @param message
     */
    public UnauthorizedLoginException(String message){
        super(message);
    }
}