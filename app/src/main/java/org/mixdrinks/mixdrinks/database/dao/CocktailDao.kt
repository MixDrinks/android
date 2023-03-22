package org.mixdrinks.mixdrinks.database.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.GoodRelationDto
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation

@Dao
interface CocktailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAll(cocktail: List<Cocktail>)

//    @Query("SELECT * FROM cocktails")
//    @Transaction
//    suspend fun getAll(): List<CocktailSnapshotDb>

//    @Query("SELECT * FROM cocktails WHERE cocktail_id = :id")
//    suspend fun getById(id: Int): CocktailSnapshotDb
}



// *** Converters move to other file

fun CocktailDto.toCocktailEntity(): Cocktail {
    return Cocktail(
        cocktailId = this.id.id,
        name = this.name,
        receipt = this.receipt.toString(),
        goods = this.goods.map {
            it.toGoodEntity(this.id.id)
        }
    )
}

fun GoodRelationDto.toGoodEntity(cocktailId: Int): CocktailToGoodRelation {
    return CocktailToGoodRelation(
        cocktailId = cocktailId,
        goodId = this.goodId.id,
        amount = this.amount,
        unit = this.unit
    )
}

// *** END Converters move to other file




//data class CocktailSnapshotDb(
//    @Embedded
//    val cocktail: Cocktail,
//    @Relation(
//        parentColumn = "cocktail_id",
//        entity = CocktailToGoodRelation::class,
//        entityColumn = "good_id",
//        associateBy = Junction(
//            value = CocktailToGoodRelation::class,
//            parentColumn = "cocktail_id",
//            entityColumn = "good_id"
//        )
//    )
//    val goods: List<CocktailToGoodRelation>
//)




//@Dao
//interface GoodDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun addAll(goods: List<Good>)
//
//    @Query("SELECT * FROM goods")
//    suspend fun getAll(): List<Good>
//
//    @Query("SELECT * FROM goods WHERE good_id = :id")
//    suspend fun getById(id: Int): Good
//}