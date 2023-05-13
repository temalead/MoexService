package com.example.moexbondservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "governmentBonds", url = "\${moex.bonds.government.url}", configuration = [FeignConfig::class])
interface GovernmentBondClient {
    @GetMapping
    fun getBondsFromMoex(): String?
}
