package kz.azamat.androidlessonnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import kotlinx.coroutines.coroutineScope
import okhttp3.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

//    private val client = OkHttpClient()
    private lateinit var textView: TextView
    private val mainViewModel: MainViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)


        button.setOnClickListener {
//            requestCall()
//            requestRetrofit(service)
            mainViewModel.getCurrencies()
        }

        mainViewModel.liveData.observe(this) { result ->
            var listText: String = ""
            result?.let {
                for (currency in it.dataList) {
                    listText += currency.toString() + "\n\n"
                }
            }
            textView.text = listText
        }
    }


//    private fun requestRetrofit(service: NetworkService) {
//        val json = service.getCurrencies().execute().body()?.string()
//        service.getCurrencies().enqueue(object : retrofit2.Callback<CurrenciesData>{
//            override fun onResponse(call: Call<CurrenciesData>, response: Response<CurrenciesData>) {
//                var listText: String = ""
//
//                response.body()?.let {
//                    for (currency in it.dataList) {
//                        listText += currency.toString() +"\n\n"
//                    }
//                }
//
//                textView.text = listText
//            }
//
//            override fun onFailure(call: Call<CurrenciesData>, t: Throwable) {
//
//            }
//        })
//    }


//    private fun requestCall() {
//        val request = Request.Builder()
//            .url("https://api.coinbase.com/v2/currencies")
//            .build()
//        try {
//            //        val response = client.newCall(request).execute()
//        } catch () {
//
//        }

//        client.newCall(request).enqueue(object : Callback{
//            override fun onFailure(call: Call, e: IOException) {
//
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                textView.text = response.body?.string()
//            }
//        })
//    }
}