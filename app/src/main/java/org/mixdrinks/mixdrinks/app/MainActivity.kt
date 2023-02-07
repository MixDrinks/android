package org.mixdrinks.mixdrinks.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.runBlocking
import org.mixdrinks.mixdrinks.features.start.CocktailListItem
import org.mixdrinks.mixdrinks.app.ui.theme.MixDrinksTheme
import org.mixdrinks.mixdrinks.features.start.data.Cocktail
import org.mixdrinks.mixdrinks.features.start.data.CocktailProvider
import org.mixdrinks.mixdrinks.features.start.data.CocktailsResponse

class MainActivity : ComponentActivity() {
    private var cocktailListResponse: CocktailsResponse = CocktailsResponse()
    private val cocktailProvider = RetrofitClient.retrofit.create(CocktailProvider::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        runBlocking {
            try {
                cocktailProvider.getCocktails(0).let {
                    cocktailListResponse = it
                }
                Log.d("MyLog", cocktailListResponse.toString())
            } catch (e: Exception) {
                Log.d("MyLog", "Exception: ${e.toString()}")
            }
        }


        setContent {
            MixDrinksTheme {
                StartScreen(cocktailListResponse.cocktails)
            }
        }
    }
}
@Composable
fun StartScreen(cocktail: List<Cocktail>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = cocktail,
            itemContent = {
                CocktailListItem(item = it)
            }
        )
    }
}