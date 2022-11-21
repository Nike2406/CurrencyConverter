package com.bukin.cssxml.main

import com.bukin.cssxml.data.model.CurrencyResponse
import com.bukin.cssxml.util.Resource

interface MainRepository {

    suspend fun getRates(symbols: String, base: String) : Resource<CurrencyResponse>
}