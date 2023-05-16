package com.anywr.anywrbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class TeacherNotFoundException extends RuntimeException {

    public TeacherNotFoundException() {
    }

    public TeacherNotFoundException(String message) {
        super(message);
    }

    public TeacherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TeacherNotFoundException(Throwable cause) {
        super(cause);
    }

    public TeacherNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
