package com.example.moexbondservice.dto;

import java.math.BigDecimal;

public record StockPriceDto(BigDecimal price, String ticker) {
}
