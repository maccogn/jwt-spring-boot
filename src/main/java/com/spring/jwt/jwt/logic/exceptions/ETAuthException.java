package com.spring.jwt.jwt.logic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ETAuthException extends RuntimeException {

    public ETAuthException(String message) {
        super(message);
    }
}
