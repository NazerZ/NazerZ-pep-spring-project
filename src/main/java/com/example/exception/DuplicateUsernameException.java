package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateUsernameException extends RuntimeException{
    /**
     * @param message
     */
    public DuplicateUsernameException(String message){
        super(message);
    }
}