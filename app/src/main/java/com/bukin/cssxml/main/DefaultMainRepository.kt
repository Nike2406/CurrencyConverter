package com.bukin.cssxml.main

import android.util.Log
import com.bukin.cssxml.data.CurrencyApi
import com.bukin.cssxml.data.model.CurrencyResponse
import com.bukin.cssxml.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(symbols: String, base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(symbols, base)
            Log.d("FUCK", "responce = $response")
            val result = response.body()
            Log.d("FUCK", "result = $result")
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Error in DefaultMainRepository")
        }
    }
}