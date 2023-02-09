package org.mixdrinks.mixdrinks.features.start.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.app.RetrofitClient
import org.mixdrinks.mixdrinks.features.start.data.Cocktail
import org.mixdrinks.mixdrinks.features.start.data.CocktailProvider

class MainViewModel : ViewModel() {
    var cocktailListResponse: List<Cocktail> by mutableStateOf(listOf())
    private val cocktailProvider = RetrofitClient.retrofit.create(CocktailProvider::class.java)

    fun getCocktail(page: Int = 0) {
        viewModelScope.launch {
            try {
                cocktailProvider.getCocktails(page).let {
                    cocktailListResponse = it.cocktails
                    Log.d("MyLog", cocktailListResponse.toString())
                }
            } catch (e: Exception) {
                Log.d("MyLog", "Exception: $e")
            }
        }
    }

}