package org.mixdrinks.mixdrinks.database.dao


import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.Junction
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.dto.GlasswareId
import org.mixdrinks.dto.GoodId
import org.mixdrinks.dto.TagId
import org.mixdrinks.dto.TasteId
import org.mixdrinks.dto.ToolId
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation
import org.mixdrinks.mixdrinks.database.entities.CocktailToTag
import org.mixdrinks.mixdrinks.database.entities.CocktailToTaste
import org.mixdrinks.mixdrinks.database.entities.CocktailToTool
import org.mixdrinks.mixdrinks.database.entities.Glassware
import org.mixdrinks.mixdrinks.database.entities.Good
import org.mixdrinks.mixdrinks.database.entities.Tag
import org.mixdrinks.mixdrinks.database.entities.Taste
import org.mixdrinks.mixdrinks.database.entities.Tool
import org.mixdrinks.mixdrinks.features.data.CocktailFull

@Dao
interface CocktailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllCocktails(cocktail: List<Cocktail>)

    @Insert(entity = CocktailToGoodRelation::class, onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToGoodRelation(cocktailToGoodRelation: List<CocktailToGoodRelation>)

    @Insert(entity = CocktailToTool::class, onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToTool(cocktailToTool: List<CocktailToTool>)

    @Insert(entity = CocktailToTag::class, onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToTag(cocktailToTag: List<CocktailToTag>)

    @Insert(entity = CocktailToTaste::class, onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToTaste(cocktailToTaste: List<CocktailToTaste>)

    @Query("SELECT * FROM cocktails")
    @Transaction
    suspend fun getAll(): List<CocktailSnapshotDatabase>

    @Query("SELECT * FROM cocktails WHERE cocktail_id = :id")
    suspend fun getById(id: Int): CocktailSnapshotDatabase

    @Query("SELECT cocktail_id, name FROM cocktails")
    suspend fun getAllShortCocktail(): List<CocktailShort>
}

data class CocktailSnapshotDatabase(
    @Embedded
    val cocktail: Cocktail,
    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "good_id",
        entity = Good::class,
        associateBy = Junction(
            CocktailToGoodRelation::class
        )
    )
    val goods: List<Good>,

    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "cocktail_id",
    )
    val goodsUnit: List<CocktailToGoodRelation>,

    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "tool_id",
        associateBy = Junction(CocktailToTool::class)
    )
    val tools: List<Tool>,
    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "tag_id",
        associateBy = Junction(CocktailToTag::class)
    )
    val tags: List<Tag>,
    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "taste_id",
        associateBy = Junction(CocktailToTaste::class)
    )
    val tastes: List<Taste>,
    @Relation(
        parentColumn = "glassware_id",
        entityColumn = "glassware_id",
        entity = Glassware::class,
    )
    val glassware: Glassware
) {
    private fun getListReceipt(receipt: String): List<String> {
        return receipt.split("|")
    }

    fun toCocktailFull(): CocktailFull {
        Log.d("good", goods.size.toString() +  goods.toString())
        return CocktailFull(
            id = CocktailId(cocktail.cocktailId),
            name = cocktail.name,
            receipt = getListReceipt(cocktail.receipt),

            goods = goods.map { good ->
                CocktailFull.Good(
                    id = GoodId(good.goodId),
                    name = good.name,
                    amount = goodsUnit.filter {
                        it.goodId == good.goodId }.first().amount,
                    unit = goodsUnit.filter {
                        it.goodId == good.goodId }.first().unit,
                )
            },
            tools = tools.map { tool ->
                CocktailFull.Tool(
                    id = ToolId(tool.toolId),
                    name = tool.name
                )
            },
            tags = tags.map { tag ->
                CocktailFull.Tag(
                    id = TagId(tag.tagId),
                    name = tag.name
                )
            },
            tastes = tastes.map { taste ->
                CocktailFull.Taste(
                    id = TasteId(taste.tasteId),
                    name = taste.name
                )
            },
            glassware = CocktailFull.Glassware(id = GlasswareId(glassware.glasswareId), name = glassware.name)
        )
    }
}

data class CocktailShort(
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    val name: String,
)
