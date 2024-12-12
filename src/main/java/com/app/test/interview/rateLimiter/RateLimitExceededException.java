package com.app.test.interview.rateLimiter;

public class RateLimitExceededException extends Exception{
    public RateLimitExceededException(String message){
        super(message);
    }
}
