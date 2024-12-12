package com.app.codes.rateLimiter;

public class NoImplementationException extends RuntimeException {

    public NoImplementationException() {
        this("Method implementation does not exist");
    }

    public NoImplementationException(String message) {
        super(message);
    }
}
