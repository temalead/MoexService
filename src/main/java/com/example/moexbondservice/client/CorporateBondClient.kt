package com.example.moexbondservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "corporateBonds", url = "\${moex.bonds.corporate.url}", configuration = [FeignConfig::class])
interface CorporateBondClient {
    @GetMapping
    fun getBondsFromMoex(): String
}
