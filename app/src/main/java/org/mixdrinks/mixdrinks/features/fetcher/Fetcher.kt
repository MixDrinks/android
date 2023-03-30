package org.mixdrinks.mixdrinks.features.fetcher

import android.util.Log
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.CocktailsSnapshot
import org.mixdrinks.mixdrinks.features.data.cocktail.CocktailProvider

class Fetcher(
    private val cocktailProvider: CocktailProvider,
    private val roomDatabase: AppDatabase
) {
    private val scope = MainScope()
    init {
        scope.launch {
            Log.d("Fetch", roomDatabase.cocktailDao().getById(1).tags.first().toString())

            insertToDataBase(cocktailProvider.getAllCocktails())
        }
    }
    private suspend fun insertToDataBase(snapshot: CocktailsSnapshot) {
        roomDatabase.glasswareDao().insertAllGlasswares(snapshot.glassware)
        roomDatabase.goodDao().insertAllGoods(snapshot.goods)
        roomDatabase.tagDao().insertAllTags(snapshot.tags)
        roomDatabase.tasteDao().insertAllTastes(snapshot.tastes)
        roomDatabase.toolDao().insertAllTools(snapshot.tools)
        roomDatabase.cocktailDao().insertAllCocktails(snapshot.cocktails)
    }
}

