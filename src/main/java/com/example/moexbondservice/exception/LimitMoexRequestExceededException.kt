package com.example.moexbondservice.exception;

public class LimitMoexRequestExceededException extends RuntimeException {
    public LimitMoexRequestExceededException(String exceededLimitsOfMoexRequests) {
        super(exceededLimitsOfMoexRequests);
    }
}
