package org.mixdrinks.mixdrinks.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.mixdrinks.mixdrinks.database.dao.CocktailDao
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation

@Database(
    entities =
        [
            Cocktail::class,
            CocktailToGoodRelation::class,
       //     Good::class,
        //    Tool::class,
        //    Tag::class,
        //    Taste::class,
        //    Glassware::class,
        //    CocktailToTool::class,
        //    CocktailToTag::class,
        //    CocktailToTaste::class,
        //    CocktailToGlassware::class,

        ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cocktailDao(): CocktailDao
   // abstract fun goodDao(): GoodDao
}