package com.tutorial.sultana.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DateNotFoundException extends RuntimeException {
    public DateNotFoundException(String message) {
        super(message);
    }
    public DateNotFoundException(String message,Throwable throwable) {
        super(message,throwable);
    }

}
