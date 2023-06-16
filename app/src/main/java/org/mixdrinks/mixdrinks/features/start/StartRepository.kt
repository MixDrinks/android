package org.mixdrinks.mixdrinks.features.start

import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.dao.CocktailsWithFilters
import org.mixdrinks.mixdrinks.features.data.CocktailShort
import org.mixdrinks.mixdrinks.features.start.filter.SelectedFilterStorage


class StartRepository(
    private val roomDatabase: AppDatabase,
    private val filterStorage: SelectedFilterStorage,
) {
    private var cocktailsFromDatabase: List<CocktailsWithFilters> = listOf()
    private var cocktails: List<CocktailShort> = listOf()
    suspend fun getCocktails(): List<CocktailShort> {
        if (cocktailsFromDatabase.isEmpty()) {
            cocktailsFromDatabase = getCocktailFromDatabase()
        }
        cocktails = if (filterStorage.selectedFilters.value.isNotEmpty()) {
            filterCocktail(cocktailsFromDatabase).map {
                CocktailShort(it.cocktailId, it.name)
            }
        } else {
            cocktailsFromDatabase.map {
                CocktailShort(it.cocktailId, it.name)
            }
        }

        return cocktails
    }

    fun searchCocktail(search: String): List<CocktailShort> {
        return cocktails.filter { it.name.lowercase().contains(search.lowercase()) }
    }

    private fun filterCocktail(cocktails: List<CocktailsWithFilters>): List<CocktailsWithFilters> {
        return cocktails.filter { cocktail ->
            cocktail.filters.find { filters ->
                filterStorage.selectedFilters.value.find {
                    it.filterId == filters.filterId && it.filterGroupId == filters.filterGroupId
                } != null
            } != null
        }
    }

    private suspend fun getCocktailFromDatabase(): List<CocktailsWithFilters> {
        return roomDatabase.cocktailDao().getAllCocktailShort().map { it.toCocktailsWithFilters() }
    }
}

