package com.bukin.cssxml.data.model

data class CurrencyResponse(
    val base: String,
    val date: String,
    val rates: Rates,
)