package com.example.moexbondservice.service.utils

import com.example.moexbondservice.dto.BondDto

interface BondParser {
    fun parse(ratesAsString: String?): List<BondDto>
}
