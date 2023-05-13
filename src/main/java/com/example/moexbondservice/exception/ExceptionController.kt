package com.example.moexbondservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {BondParsingException.class})
    public ResponseEntity<ErrorDto> handleOnParsing(Exception ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {LimitMoexRequestExceededException.class})
    public ResponseEntity<ErrorDto> handleLimitation(Exception ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getLocalizedMessage()), HttpStatus.TOO_MANY_REQUESTS);
    }
}
