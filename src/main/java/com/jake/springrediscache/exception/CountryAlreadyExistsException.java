package com.jake.springrediscache.exception;

public class CountryAlreadyExistsException extends RuntimeException {

    public CountryAlreadyExistsException(String message) {
        super(message);
    }
}
