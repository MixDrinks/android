package org.mixdrinks.mixdrinks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.mixdrinks.mixdrinks.database.dao.CocktailDao
import org.mixdrinks.mixdrinks.database.dao.FilterGroupDao
import org.mixdrinks.mixdrinks.database.dao.GlasswareDao
import org.mixdrinks.mixdrinks.database.dao.GoodDao
import org.mixdrinks.mixdrinks.database.dao.TagDao
import org.mixdrinks.mixdrinks.database.dao.TasteDao
import org.mixdrinks.mixdrinks.database.dao.ToolDao
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

@Database(
    entities =
        [
            Cocktail::class,
            CocktailToGoodRelation::class,
            Good::class,
            Glassware::class,
            Tool::class,
            Tag::class,
            Taste::class,
            CocktailToTool::class,
            CocktailToTag::class,
            CocktailToTaste::class,
            FilterGroup::class,
            Filters::class,
            FilterWithCocktailIds::class,
        ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
    abstract fun goodDao(): GoodDao
    abstract fun glasswareDao(): GlasswareDao
    abstract fun tagDao(): TagDao
    abstract fun toolDao(): ToolDao
    abstract fun tasteDao(): TasteDao
    abstract fun filterGroupDao(): FilterGroupDao
}

