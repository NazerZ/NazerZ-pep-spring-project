package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MessageCreationException extends RuntimeException{
    /**
     * @param message
     */
    public MessageCreationException(String message){
        super(message);
    }
}