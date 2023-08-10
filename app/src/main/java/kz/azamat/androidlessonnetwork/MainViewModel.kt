package kz.azamat.androidlessonnetwork

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val _liveData = MutableLiveData<CurrenciesData>()

    val liveData: LiveData<CurrenciesData>
        get() = _liveData

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.coinbase.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(NetworkService::class.java)

    fun getCurrencies() {
        viewModelScope.launch {
            try {
                val result = service.getCurrencies()
                _liveData.value = result.body()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}