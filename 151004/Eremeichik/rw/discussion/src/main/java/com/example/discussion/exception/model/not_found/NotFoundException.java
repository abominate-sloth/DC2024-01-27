package com.example.discussion.exception.model.not_found;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }
}
