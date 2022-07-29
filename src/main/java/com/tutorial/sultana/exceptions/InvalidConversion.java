package com.tutorial.sultana.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidConversion extends RuntimeException {
    public InvalidConversion(String message) {
        super(message);
    }
    public InvalidConversion(String message,Throwable throwable) {
        super(message,throwable);
    }


}
