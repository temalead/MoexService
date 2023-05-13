package com.example.moexbondservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@AllArgsConstructor
@Value
public class Stock {
    String ticker;
    String figi;
    String name;
    String type;
    Currency currency;
    String source;

}
