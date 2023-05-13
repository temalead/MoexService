package com.example.moexbondservice.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionController {
    @ExceptionHandler(value = [BondParsingException::class])
    fun handleOnParsing(ex: Exception): ResponseEntity<ErrorDto> {
        return ResponseEntity(ErrorDto(ex.localizedMessage), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [LimitMoexRequestExceededException::class])
    fun handleLimitation(ex: Exception): ResponseEntity<ErrorDto> {
        return ResponseEntity(ErrorDto(ex.localizedMessage), HttpStatus.TOO_MANY_REQUESTS)
    }
}
