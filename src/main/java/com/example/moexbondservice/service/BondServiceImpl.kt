package com.example.moexbondservice.service;

import com.example.moexbondservice.dto.*;
import com.example.moexbondservice.model.Currency;
import com.example.moexbondservice.model.Stock;
import com.example.moexbondservice.service.utils.CorporateBondService;
import com.example.moexbondservice.service.utils.GovernmentBondService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class BondServiceImpl implements BondService{
    private final CorporateBondService corporateBondService;
    private final GovernmentBondService governmentBondService;

    @Override
    public StocksDto getBondsFromMoex(TickersDto tickers) {
        List<BondDto> allBonds = getAllBonds();

        return new StocksDto(allBonds.stream()
                .filter(bond -> isContainsBondInTickers(tickers, bond.ticker()))
                .map(this::createStock)
                .toList());
    }

    private List<BondDto> getAllBonds() {
        return Stream.of(
                        governmentBondService.getGovernmentBonds(),
                        corporateBondService.getCorporateBonds()
                )
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public StockPricesDto getPricesByFigies(TickersDto tickers) {
        List<BondDto> allBonds = getAllBonds();

        return new StockPricesDto(allBonds.stream()
                .map(this::createStockPrice)
                .toList());
    }

    private StockPriceDto createStockPrice(BondDto bond) {
        return new StockPriceDto(percentToRealPrice(bond), bond.ticker());
    }

    private BigDecimal percentToRealPrice(BondDto bond) {
        return bond.price().multiply(BigDecimal.TEN);
    }

    private static boolean isContainsBondInTickers(TickersDto tickers, String bondTicker) {
        return tickers.tickers().contains(bondTicker);
    }


    private Stock createStock(BondDto bondDto) {
        return Stock.builder()
                .name(bondDto.name())
                .type("Bond")
                .figi(bondDto.ticker())
                .ticker(bondDto.ticker())
                .currency(Currency.RUB)
                .source("MOEX")
                .build();
    }
}
