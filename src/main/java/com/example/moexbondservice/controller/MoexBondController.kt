package com.example.moexbondservice.controller

import com.example.moexbondservice.dto.StockPricesDto
import com.example.moexbondservice.dto.StocksDto
import com.example.moexbondservice.dto.TickersDto
import com.example.moexbondservice.service.BondService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bonds")
class MoexBondController {
    private val bondService: BondService? = null
    @PostMapping("/getBondsByTickers")
    fun getBondsFromMoex(@RequestBody tickers: TickersDto): StocksDto {
        return bondService!!.getBondsFromMoex(tickers)
    }

    @PostMapping("/prices")
    fun getPrices(@RequestBody tickers: TickersDto?): StockPricesDto {
        return bondService!!.getPricesByTickers(tickers)
    }
}
