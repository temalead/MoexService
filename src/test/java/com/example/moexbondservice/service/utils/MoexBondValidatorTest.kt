package com.example.moexbondservice.service.utils

import com.example.moexbondservice.dto.BondDto
import com.example.moexbondservice.exception.LimitMoexRequestExceededException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MoexBondValidatorTest {
    private var moexBondValidator: MoexBondValidator? = null
    @BeforeEach
    fun setUp() {
        moexBondValidator = MoexBondValidator()
    }

    @Test
    fun validateMoexLimitation() {
        Assertions
            .assertThrows(LimitMoexRequestExceededException::class.java) {
                moexBondValidator!!.validateMoexLimitation(
                    listOf<BondDto>()
                )
            }
    }
}