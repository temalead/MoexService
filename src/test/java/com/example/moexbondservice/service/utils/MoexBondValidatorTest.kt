package com.example.moexbondservice.service.utils;

import com.example.moexbondservice.exception.LimitMoexRequestExceededException;
import com.example.moexbondservice.service.utils.MoexBondValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MoexBondValidatorTest {

    private MoexBondValidator moexBondValidator;

    @BeforeEach
    public void setUp() {
        moexBondValidator = new MoexBondValidator();
    }
    @Test
    void validateMoexLimitation() {
        Assertions
                .assertThrows(LimitMoexRequestExceededException.class, () ->
        moexBondValidator.validateMoexLimitation(List.of()));
    }
}