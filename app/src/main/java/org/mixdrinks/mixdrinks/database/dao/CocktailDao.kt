package org.mixdrinks.mixdrinks.database.dao


import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.Junction
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation

@Dao
interface CocktailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAll(cocktail: List<Cocktail>)

    @Query("SELECT * FROM cocktails")
    @Transaction
    suspend fun getAll(): List<CocktailSnapshotDatabase>

    @Query("SELECT * FROM cocktails WHERE cocktail_id = :id")
    suspend fun getById(id: Int): CocktailSnapshotDatabase
}
data class CocktailSnapshotDatabase(
    @Embedded
    val cocktail: Cocktail,
    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "good_id",
        associateBy = Junction(
            value = CocktailToGoodRelation::class
        )
    )
    val goods: List<CocktailToGoodRelation>
)




