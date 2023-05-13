package com.example.moexbondservice.exception;

public class BondParsingException extends RuntimeException {
    public BondParsingException(Exception ex) {
        super(ex);
    }
}
