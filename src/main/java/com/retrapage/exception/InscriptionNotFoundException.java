package com.retrapage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InscriptionNotFoundException extends RuntimeException{

    public InscriptionNotFoundException(Long id) {
        super("Registration not found with ID: " + id);
    }
}
