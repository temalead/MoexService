package com.example.moexbondservice.service.utils

import com.example.moexbondservice.client.GovernmentBondClient
import com.example.moexbondservice.dto.BondDto
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
open class GovernmentBondService(
    private val governmentBondClient: GovernmentBondClient,
    private val bondParser: BondParser,
    private val validator: MoexBondValidator
) {

    @Cacheable(value = ["govs"])
    open fun getGovernmentBonds(): List<BondDto?>? {
        val governmentRates = governmentBondClient.getBondsFromMoex()
        val bonds = bondParser.parse(governmentRates)
        validator.validateMoexLimitation(bonds)
        return bonds
    }
}
