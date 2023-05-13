package com.example.moexbondservice.service

import com.example.moexbondservice.dto.*
import com.example.moexbondservice.model.Currency
import com.example.moexbondservice.model.Stock
import com.example.moexbondservice.service.utils.CorporateBondService
import com.example.moexbondservice.service.utils.GovernmentBondService
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.util.stream.Stream

@Service
class BondServiceImpl(
    private val corporateBondService: CorporateBondService,
    private val governmentBondService: GovernmentBondService
) : BondService {
    override fun getBondsFromMoex(tickers: TickersDto): StocksDto {
        val allBonds = allBonds()
        return StocksDto(
            allBonds.stream()
                .filter { bond: BondDto? -> isContainsBondInTickers(tickers, bond!!.ticker) }
                .map { bondDto: BondDto? -> createStock(bondDto) }
                .toList())
    }

    private fun allBonds(): List<BondDto?> {
        return Stream.of(
            governmentBondService.getGovernmentBonds(),
            corporateBondService.getCorporateBonds()
        )
            .flatMap { obj: List<BondDto?>? -> obj!!.stream() }
            .toList()
    }

    override fun getPricesByTickers(figies: TickersDto?): StockPricesDto {
        val allBonds = allBonds()
        return StockPricesDto(allBonds.stream()
            .map { bond: BondDto? -> createStockPrice(bond) }
            .toList())
    }

    private fun createStockPrice(bond: BondDto?): StockPriceDto {
        return StockPriceDto(percentToRealPrice(bond), bond!!.ticker)
    }

    private fun percentToRealPrice(bond: BondDto?): BigDecimal {
        return bond!!.price.multiply(BigDecimal.TEN)
    }

    private fun createStock(bondDto: BondDto?): Stock {
        return Stock.Builder()
            .name(bondDto!!.name)
            .type("Bond")
            .figi(bondDto.ticker)
            .ticker(bondDto.ticker)
            .currency(Currency.RUB)
            .source("MOEX")
            .build()
    }

    private fun isContainsBondInTickers(tickers: TickersDto, bondTicker: String): Boolean {
        return tickers.tickers.contains(bondTicker)
    }
}
