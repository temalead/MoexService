package com.example.moexbondservice.model;

public enum Currency {
    RUB("RUB"),
    USD("USD");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
