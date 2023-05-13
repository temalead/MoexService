package com.example.moexbondservice.service.utils

import com.example.moexbondservice.dto.BondDto
import com.example.moexbondservice.exception.LimitMoexRequestExceededException
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class MoexBondValidator {
    private val log = KotlinLogging.logger{}
    fun validateMoexLimitation(bonds: List<BondDto?>?) {
        if (bonds!!.isEmpty()) {
            log.error("Exceeded limits of MOEX requests")
            throw LimitMoexRequestExceededException("Exceeded limits of MOEX requests")
        }
    }
}
