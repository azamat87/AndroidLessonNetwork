package kz.azamat.androidlessonnetwork
import com.google.gson.annotations.SerializedName

data class CurrenciesData(
    @SerializedName("data")
    val dataList: List<Currency>
)

data class Currency(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("min_size")
    val minSize: String
)
