package org.mixdrinks.mixdrinks.database.dao


import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.Junction
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.dto.GlasswareId
import org.mixdrinks.dto.GoodId
import org.mixdrinks.dto.GoodRelationDto
import org.mixdrinks.dto.TagId
import org.mixdrinks.dto.TasteId
import org.mixdrinks.dto.ToolId
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation
import org.mixdrinks.mixdrinks.database.entities.CocktailToTag
import org.mixdrinks.mixdrinks.database.entities.CocktailToTaste
import org.mixdrinks.mixdrinks.database.entities.CocktailToTool

@Dao
interface CocktailDao {
    suspend fun insertAllCocktails(cocktails: List<CocktailDto>) {
        addAllCocktails(
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
            addCocktailToGoodRelation(
                cocktail.goods.map { good ->
                    CocktailToGoodRelation(
                        cocktailId = cocktail.id.id,
                        goodId = good.goodId.id,
                        amount = good.amount,
                        unit = good.unit
                    )
                }
            )
            addCocktailToTool (
                cocktail.tools.map { tool ->
                    CocktailToTool (
                        cocktailId = cocktail.id.id,
                        toolId = tool.id
                    )
                }
            )
            addCocktailToTag(
                cocktail.tags.map { tag ->
                    CocktailToTag(
                        cocktailId = cocktail.id.id,
                        tagId = tag.id
                    )
                }
            )
            addCocktailToTaste(
                cocktail.tastes.map { taste ->
                    CocktailToTaste(
                        cocktailId = cocktail.id.id,
                        tasteId = taste.id
                    )
                }
            )
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllCocktails(cocktail: List<Cocktail>)

    @Insert(entity = CocktailToGoodRelation::class,  onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToGoodRelation(cocktailToGoodRelation: List<CocktailToGoodRelation>)

    @Insert(entity = CocktailToTool::class,  onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToTool(cocktailToTool: List<CocktailToTool>)

    @Insert(entity = CocktailToTag::class,  onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToTag(cocktailToTag: List<CocktailToTag>)

    @Insert(entity = CocktailToTaste::class,  onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addCocktailToTaste(cocktailToTaste: List<CocktailToTaste>)

    @Query("SELECT * FROM cocktails")
    @Transaction
    suspend fun getAll(): List<CocktailSnapshotDatabase>

    @Query("SELECT * FROM cocktails LIMIT :limit OFFSET :offset")
    @Transaction
    suspend fun getAll(limit: Int, offset: Int): List<CocktailSnapshotDatabase>

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
    val goods: List<CocktailToGoodRelation>,
    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "tool_id",
        associateBy = Junction(
            value = CocktailToTool::class
        )
    )
    val tools: List<CocktailToTool>,
    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "tag_id",
        associateBy = Junction(
            value = CocktailToTag::class
        )
    )
    val tags: List<CocktailToTag>,
    @Relation(
        parentColumn = "cocktail_id",
        entityColumn = "taste_id",
        associateBy = Junction(
            value = CocktailToTaste::class
        )
    )
    val tastes: List<CocktailToTaste>,
) {
    fun toCocktailDto(): CocktailDto {
        return CocktailDto(
            id = CocktailId(cocktail.cocktailId),
            name = cocktail.name,
            receipt = toListReceipt(cocktail.receipt),
            goods = goods.map { good ->
                GoodRelationDto(
                    goodId = GoodId(good.goodId),
                    amount = good.amount,
                    unit = good.unit
                )
            },
            tools = tools.map { tool -> ToolId(tool.toolId) },
            tags = tags.map { tag -> TagId(tag.tagId) },
            tastes = tastes.map { taste -> TasteId(taste.tasteId) },
            glassware = GlasswareId(cocktail.glasswareId)
        )
    }

    private fun toListReceipt(receipt: String): List<String> {
        return receipt.split("|")
    }
}

