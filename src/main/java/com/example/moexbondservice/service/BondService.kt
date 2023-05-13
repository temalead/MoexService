package com.example.moexbondservice.service

import com.example.moexbondservice.dto.StockPricesDto
import com.example.moexbondservice.dto.StocksDto
import com.example.moexbondservice.dto.TickersDto

interface BondService {
    fun getBondsFromMoex(tickers: TickersDto): StocksDto
    fun getPricesByTickers(figies: TickersDto?): StockPricesDto
}
