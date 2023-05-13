package com.example.moexbondservice.model

class Stock private constructor(
    var ticker: String?,
    var figi: String?,
    var name: String?,
    var type: String?,
    var currency: Currency?,
    var source: String?
) {
    data class Builder(
        var ticker: String? = null,
        var figi: String? = null,
        var name: String? = null,
        var type: String? = null,
        var currency: Currency? = null,
        var source: String? = null
    ) {
        fun ticker(ticker: String) = apply { this.ticker = ticker }
        fun figi(figi: String) = apply { this.figi = figi }
        fun name(name: String) = apply { this.name = name }
        fun type(type: String) = apply { this.type = type }
        fun currency(currency: Currency) = apply { this.currency = currency }
        fun source(source: String) = apply { this.source = source }

        fun build() = Stock(ticker, figi, name, type, currency, source)
    }
}
