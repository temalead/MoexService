package com.example.moexbondservice.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal

data class BondDto(
    val ticker: String,
    val name: String,
    @field:JsonFormat(shape = JsonFormat.Shape.STRING) @param:JsonFormat(shape = JsonFormat.Shape.STRING) val price: BigDecimal
)
