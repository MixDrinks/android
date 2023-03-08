package org.mixdrinks.mixdrinks.features.start.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.app.RetrofitClient
import org.mixdrinks.mixdrinks.features.data.Cocktail
import org.mixdrinks.mixdrinks.features.data.CocktailProvider

class StartScreenViewModel(
    private val cocktailProvider: CocktailProvider = RetrofitClient.retrofit.create(CocktailProvider::class.java)
) : ViewModel() {
    var cocktailListResponse: List<Cocktail> by mutableStateOf(listOf())

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
            Log.d("MyLog", cocktailListResponse.size.toString())
        }
    }
}


