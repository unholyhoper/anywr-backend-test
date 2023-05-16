package com.anywr.anywrbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ClassNotFoundException extends RuntimeException {

    public ClassNotFoundException() {
    }

    public ClassNotFoundException(String message) {
        super(message);
    }

    public ClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassNotFoundException(Throwable cause) {
        super(cause);
    }

    public ClassNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
