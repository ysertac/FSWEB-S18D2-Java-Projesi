package com.workintech.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PlantException extends RuntimeException {
    private HttpStatus httpStatus;

    public PlantException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
