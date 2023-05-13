package com.example.moexbondservice.controller;

import com.example.moexbondservice.dto.StockPricesDto;
import com.example.moexbondservice.dto.StocksDto;
import com.example.moexbondservice.dto.TickersDto;
import com.example.moexbondservice.service.BondService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bonds")
public class MoexBondController {

    private final BondService bondService;

    @PostMapping("/getBondsByTickers")
    public StocksDto getBondsFromMoex(@RequestBody TickersDto tickers) {
        return bondService.getBondsFromMoex(tickers);
    }

    @PostMapping("/prices")
    public StockPricesDto getPrices(@RequestBody TickersDto tickers) {
        return bondService.getPricesByFigies(tickers);
    }
}
