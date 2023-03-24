package org.mixdrinks.mixdrinks.features.fetcher

import android.util.Log
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.dto.SnapshotDto
import org.mixdrinks.dto.TagDto
import org.mixdrinks.dto.TasteDto
import org.mixdrinks.dto.ToolDto
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.toCocktailEntity
import org.mixdrinks.mixdrinks.database.toGlasswareEntity
import org.mixdrinks.mixdrinks.database.toGoodEntity
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
//        insertToDataBase(snapshot.tools)
        insertToDataBaseGoodDto(snapshot.goods)
//        insertToDataBase(snapshot.tags)
//        insertToDataBase(snapshot.tastes)
        insertToDataBaseGlasswareDto(snapshot.glassware)
        insertToDataBaseCocktailDto(snapshot.cocktails)
    }

//    private fun insertToDataBase(tools: List<ToolDto>) {
//        // @Dao insert
//    }

    private suspend fun insertToDataBaseGoodDto(goods: List<GoodDto>) {
        roomDatabase.goodDao().addAllGoods(goods.map { it.toGoodEntity() })
    }

//    private suspend fun insertToDataBase(tags: List<TagDto>) {
//        // @Dao insert
//    }
//
//    private suspend fun insertToDataBase(tastes: List<TasteDto>) {
//        // @Dao insert
//    }

    private suspend fun insertToDataBaseGlasswareDto(glassware: List<GlasswareDto>) {
        roomDatabase.glasswareDao().addAll(glassware.map { it.toGlasswareEntity() })
    }

    private suspend fun insertToDataBaseCocktailDto(cocktails: List<CocktailDto>) {
        roomDatabase.cocktailDao().addAll(cocktails.map { it.toCocktailEntity() })
    }





}