package org.mixdrinks.mixdrinks.features.fetcher

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.mixdrinks.dto.SnapshotDto
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.features.data.CocktailProvider

class Fetcher(
    private val cocktailProvider: CocktailProvider,
    private val roomDatabase: AppDatabase
) {
    private val scope = MainScope()
    init {
        scope.launch {
            if(roomDatabase.cocktailDao().getAll().isEmpty()) {
                insertToDataBase(cocktailProvider.getAllCocktails())
            }
        }
    }
    private suspend fun insertToDataBase(snapshot: SnapshotDto) {
        roomDatabase.glasswareDao().insertAllGlasswares(snapshot.glassware)
        roomDatabase.goodDao().insertAllGoods(snapshot.goods)
        roomDatabase.tagDao().insertAllTags(snapshot.tags)
        roomDatabase.tasteDao().insertAllTastes(snapshot.tastes)
        roomDatabase.toolDao().insertAllTools(snapshot.tools)
        roomDatabase.cocktailDao().insertAllCocktails(snapshot.cocktails)
        roomDatabase.filterGroupDao().insertAllFilters(snapshot.filterGroups)
    }
}

