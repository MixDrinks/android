package org.mixdrinks.mixdrinks.features.fetcher

import android.util.Log
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.dto.TagDto
import org.mixdrinks.dto.TasteDto
import org.mixdrinks.dto.ToolDto
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.toCocktailEntity
import org.mixdrinks.mixdrinks.database.toGlasswareEntity
import org.mixdrinks.mixdrinks.database.toGoodEntity
import org.mixdrinks.mixdrinks.database.toTagEntity
import org.mixdrinks.mixdrinks.database.toTasteEntity
import org.mixdrinks.mixdrinks.database.toToolEntity
import org.mixdrinks.mixdrinks.features.data.CocktailsSnapshot
import org.mixdrinks.mixdrinks.features.data.cocktail.CocktailProvider

class Fetcher(
    private val cocktailProvider: CocktailProvider,
    private val roomDatabase: AppDatabase
) {
    private val scope = MainScope()
    private lateinit var snapshot: CocktailsSnapshot
    init {
        Log.d("fetch", "fetch")
        scope.launch {
            getSnapshot()
            startInsertToDataBase(snapshot)
        }
    }

    private suspend fun getSnapshot() {
        snapshot = cocktailProvider.getAllCocktails()
    }

    private suspend fun startInsertToDataBase(snapshot: CocktailsSnapshot) {
        insertToDataBaseTools(snapshot.tools)
        insertToDataBaseGoodDto(snapshot.goods)
        insertToDataBaseTags(snapshot.tags)
        insertToDataBaseTastes(snapshot.tastes)
        insertToDataBaseGlasswareDto(snapshot.glassware)
        insertToDataBaseCocktailDto(snapshot.cocktails)
    }

    private suspend fun insertToDataBaseTools(tools: List<ToolDto>) {
        roomDatabase.toolDao().addAllTools(tools.map { it.toToolEntity() })
    }

    private suspend fun insertToDataBaseGoodDto(goods: List<GoodDto>) {
        roomDatabase.goodDao().addAllGoods(goods.map { it.toGoodEntity() })
    }

    private suspend fun insertToDataBaseTags(tags: List<TagDto>) {
        roomDatabase.tagDao().addAllTags(tags.map { it.toTagEntity() })
    }

    private suspend fun insertToDataBaseTastes(tastes: List<TasteDto>) {
        roomDatabase.tasteDao().addAllTastes(tastes.map { it.toTasteEntity() })
    }

    private suspend fun insertToDataBaseGlasswareDto(glassware: List<GlasswareDto>) {
        roomDatabase.glasswareDao().addAll(glassware.map { it.toGlasswareEntity() })
    }

    private suspend fun insertToDataBaseCocktailDto(cocktails: List<CocktailDto>) {
        roomDatabase.cocktailDao().addAll(cocktails.map { it.toCocktailEntity() })
    }
}