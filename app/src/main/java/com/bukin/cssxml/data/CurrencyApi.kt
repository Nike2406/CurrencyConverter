package com.bukin.cssxml.data

import com.bukin.cssxml.data.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface CurrencyApi {

    @Headers("apikey: $QUERY_API_KEY")
    @GET("/exchangerates_data/latest?")
    suspend fun getRates(
        @Query(QUERY_SYMBOLS) symbols: String,
        @Query(QUERY_BASE) base: String
    ): Response<CurrencyResponse>

    companion object {

        private const val QUERY_API_KEY = "WLOhzEUp4kApr1ifbY2YrsI4EMBIebnF"
        private const val QUERY_SYMBOLS = "symbols"
        private const val QUERY_BASE = "base"
    }
}