package com.example.moexbondservice.service;

import com.example.moexbondservice.dto.StockPricesDto;
import com.example.moexbondservice.dto.StocksDto;
import com.example.moexbondservice.dto.TickersDto;

public interface BondService {
    StocksDto getBondsFromMoex(TickersDto tickers);

    StockPricesDto getPricesByFigies(TickersDto figies);
}
