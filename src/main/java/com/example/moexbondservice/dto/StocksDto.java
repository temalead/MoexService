package com.example.moexbondservice.dto;

import com.example.moexbondservice.model.Stock;

import java.util.List;

public record StocksDto(List<Stock> stocks) {
}
