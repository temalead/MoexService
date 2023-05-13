package com.example.moexbondservice.service.utils

import com.example.moexbondservice.client.CorporateBondClient
import com.example.moexbondservice.dto.BondDto
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
open class CorporateBondService(private val bondParser: BondParser,
                                private val corporateBondClient: CorporateBondClient,
                                private val moexBondValidator: MoexBondValidator) {

    @Cacheable(value = ["corps"])
    open fun getCorporateBonds(): List<BondDto?>? {
        val corporateRates = corporateBondClient.getBondsFromMoex()
        val bonds = bondParser.parse(corporateRates)
        moexBondValidator.validateMoexLimitation(bonds)
        return bonds
    }
}
