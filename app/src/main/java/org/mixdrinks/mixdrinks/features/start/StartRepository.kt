package org.mixdrinks.mixdrinks.features.start;

import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.dao.CocktailsWithFilters
import org.mixdrinks.mixdrinks.features.data.CocktailShort
import org.mixdrinks.mixdrinks.features.start.ui.filter.SelectedFilterStorage


class StartRepository(
    private val roomDatabase: AppDatabase,
    private val filterStorage: SelectedFilterStorage,
) {
    private var cocktails: List<CocktailsWithFilters> = listOf()

    suspend fun getCocktails(): List<CocktailShort> {
        if (cocktails.isEmpty()) {
            cocktails = getCocktailFromDatabase()
        }
        if (filterStorage.selectedFilters.value.isNotEmpty()) {
            return filterCocktail(cocktails).map { CocktailShort(it.cocktailId, it.name) }
        }

        return cocktails.map { CocktailShort(it.cocktailId, it.name) }
    }

    fun searchCocktail(search: String): List<CocktailShort> {
        return cocktails
            .filter { it.name.lowercase().contains(search.lowercase()) }
            .map { CocktailShort(it.cocktailId, it.name) }
    }


    private fun filterCocktail(cocktails: List<CocktailsWithFilters>): List<CocktailsWithFilters> {
        return cocktails.filter { cocktail ->
            cocktail.filters.find { filterId ->
                filterStorage.selectedFilters.value.find { it == filterId } != null
            } != null
        }
    }

    private suspend fun getCocktailFromDatabase(): List<CocktailsWithFilters> {
        return roomDatabase.cocktailDao().getAllCocktailShort2().map { it.toCocktailsWithFilters() }
    }


}

