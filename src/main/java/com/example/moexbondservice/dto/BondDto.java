package com.example.moexbondservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

public record BondDto(String ticker, String name, @JsonFormat(shape = JsonFormat.Shape.STRING) BigDecimal price) {
}
