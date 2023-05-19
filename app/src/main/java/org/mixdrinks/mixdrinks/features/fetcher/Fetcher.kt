package org.mixdrinks.mixdrinks.features.fetcher

import android.util.Log
import androidx.room.Transaction
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.FilterGroupDto
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.dto.SnapshotDto
import org.mixdrinks.dto.TagDto
import org.mixdrinks.dto.TasteDto
import org.mixdrinks.dto.ToolDto
import org.mixdrinks.mixdrinks.database.AppDatabase
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation
import org.mixdrinks.mixdrinks.database.entities.CocktailToTag
import org.mixdrinks.mixdrinks.database.entities.CocktailToTaste
import org.mixdrinks.mixdrinks.database.entities.CocktailToTool
import org.mixdrinks.mixdrinks.database.entities.FilterGroup
import org.mixdrinks.mixdrinks.database.entities.FilterWithCocktailIds
import org.mixdrinks.mixdrinks.database.entities.Filters
import org.mixdrinks.mixdrinks.database.entities.Glassware
import org.mixdrinks.mixdrinks.database.entities.Good
import org.mixdrinks.mixdrinks.database.entities.Tag
import org.mixdrinks.mixdrinks.database.entities.Taste
import org.mixdrinks.mixdrinks.database.entities.Tool
import org.mixdrinks.mixdrinks.features.data.MixDrinkService

class Fetcher(
    private val cocktailProvider: MixDrinkService,
    private val roomDatabase: AppDatabase,
) {
    private val scope = MainScope()

    init {
        Log.d("init", "init")
        scope.launch {
            if (roomDatabase.cocktailDao().getAll().isEmpty()) {
                insertToDataBase(cocktailProvider.getAllCocktails())
            }
            //insertToDataBase(cocktailProvider.getAllCocktails())

            //  Log.d("init", "launch")

        }
    }

    private suspend fun insertToDataBase(snapshot: SnapshotDto) {
        insertAllGlasswares(snapshot.glassware)
        insertAllGoods(snapshot.goods)
        insertAllTags(snapshot.tags)
        insertAllTastes(snapshot.tastes)
        insertAllTools(snapshot.tools)
        insertAllCocktails(snapshot.cocktails)
        insertAllFilters(snapshot.filterGroups)
    }

    @Transaction
    private suspend fun insertAllGlasswares(glasswares: List<GlasswareDto>) {
        roomDatabase.glasswareDao().addAll(glasswares.map { glassware ->
            Glassware(
                glasswareId = glassware.id.value,
                name = glassware.name,
                about = glassware.about
            )
        })
    }

    @Transaction
    private suspend fun insertAllGoods(goods: List<GoodDto>) {
        roomDatabase.goodDao().addAll(goods.map { good ->
            Good(
                goodId = good.id.id,
                name = good.name,
                about = good.about
            )
        })
    }

    @Transaction
    private suspend fun insertAllTags(tags: List<TagDto>) {
        roomDatabase.tagDao().addAll(tags.map { tag ->
            Tag(
                tagId = tag.id.id,
                name = tag.name,
            )
        })
    }

    @Transaction
    private suspend fun insertAllTastes(tastes: List<TasteDto>) {
        roomDatabase.tasteDao().addAll(tastes.map { taste ->
            Taste(
                tasteId = taste.id.id,
                name = taste.name,
            )
        })
    }

    @Transaction
    private suspend fun insertAllTools(tools: List<ToolDto>) {
        roomDatabase.toolDao().addAll(tools.map { tool ->
            Tool(
                toolId = tool.id.id,
                name = tool.name,
                about = tool.about
            )
        })
    }

    @Transaction
    private suspend fun insertAllCocktails(cocktails: List<CocktailDto>) {
        roomDatabase.cocktailDao().addAllCocktails(
            cocktails.map { cocktail ->
                Cocktail(
                    cocktailId = cocktail.id.id,
                    name = cocktail.name,
                    receipt = cocktail.receipt.joinToString("|"),
                    glasswareId = cocktail.glassware.value
                )
            }
        )
        cocktails.map { cocktail ->
            roomDatabase.cocktailDao().addCocktailToGoodRelation(
                cocktail.goods.map { good ->
                    CocktailToGoodRelation(
                        cocktailId = cocktail.id.id,
                        goodId = good.goodId.id,
                        amount = good.amount,
                        unit = good.unit
                    )
                }
            )
            roomDatabase.cocktailDao().addCocktailToTool(
                cocktail.tools.map { tool ->
                    CocktailToTool(
                        cocktailId = cocktail.id.id,
                        toolId = tool.id
                    )
                }
            )
            roomDatabase.cocktailDao().addCocktailToTag(
                cocktail.tags.map { tag ->
                    CocktailToTag(
                        cocktailId = cocktail.id.id,
                        tagId = tag.id
                    )
                }
            )
            roomDatabase.cocktailDao().addCocktailToTaste(
                cocktail.tastes.map { taste ->
                    CocktailToTaste(
                        cocktailId = cocktail.id.id,
                        tasteId = taste.id
                    )
                }
            )
        }
    }

    //    @Transaction
    private suspend fun insertAllFilters(filterGroup: List<FilterGroupDto>) {
        filterGroup.map { item ->
            roomDatabase.filterGroupDao().addFilterGroup(
                FilterGroup(
                    id = item.id.value,
                    name = item.name,
                    selectionType = item.selectionType
                )
            )
            item.filters.map {
                roomDatabase.filterGroupDao().addFilter(
                    Filters(
                        filterId = it.id.value,
                        filterGroupId = item.id.value,
                        name = it.name
                    )
                )
                roomDatabase.filterGroupDao().addAllFilterWithCocktailId(
                    it.cocktailIds.map { cocktailId ->
                        FilterWithCocktailIds(
                            filterId = it.id.value,
                            cocktailId = cocktailId.id
                        )
                    }
                )
            }
        }

//        roomDatabase.filterGroupDao().addAllFilterGroups(
//            filterGroup.map {
//                FilterGroup(
//                    id = it.id.value,
//                    name = it.name,
//                    selectionType = it.selectionType
//                )
//            }
//        )
//        filterGroup.map {
//            roomDatabase.filterGroupDao().addAllFilters(
//                it.filters.map { filter ->
//                    Filters(
//                        filterId = filter.id.value,
//                        filterGroupId = it.id.value,
//                        name = filter.name
//                    )
//                }
//            )
//        }
//        filterGroup.map {
//            it.filters.map { filter ->
//                roomDatabase.filterGroupDao().addAllFilterWithCocktailId(
//                    filter.cocktailIds.map { cocktailId ->
//                        FilterWithCocktailIds(
//                            filterId = filter.id.value,
//                            cocktailId = cocktailId.id
//                        )
//                    }
//                )
//            }
//        }
    }
}
