package kz.azamat.androidlessonnetwork

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface NetworkService {

    @GET("v2/currencies")
    suspend fun getCurrencies(): Response<CurrenciesData>

}