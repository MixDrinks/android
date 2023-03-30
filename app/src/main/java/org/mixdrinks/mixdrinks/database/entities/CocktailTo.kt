package org.mixdrinks.mixdrinks.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE

@Entity(
    tableName = "cocktails_to_goods_relation",
    primaryKeys = ["cocktail_id", "good_id"],
    foreignKeys = [
        ForeignKey(
            entity = Cocktail::class,
            parentColumns = arrayOf("cocktail_id"),
            childColumns = arrayOf("cocktail_id"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
        ForeignKey(
            entity = Good::class,
            parentColumns = arrayOf("good_id"),
            childColumns = arrayOf("good_id"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
    ]
)
data class CocktailToGoodRelation(
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    @ColumnInfo(name = "good_id", index = true)
    val goodId: Int,
    @ColumnInfo(name = "amount")
    val amount: Int,
    @ColumnInfo("unit")
    val unit: String
)

@Entity(
    tableName = "cocktails_to_tools",
    primaryKeys = ["cocktail_id", "tool_id"],
    foreignKeys = [
        ForeignKey(
            entity = Cocktail::class,
            parentColumns = arrayOf("cocktail_id"),
            childColumns = arrayOf("cocktail_id"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
        ForeignKey(
            entity = Tool::class,
            parentColumns = arrayOf("tool_id"),
            childColumns = arrayOf("tool_id"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
    ]
)
data class CocktailToTool(
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    @ColumnInfo(name = "tool_id", index = true)
    val toolId: Int

)

@Entity(
    tableName = "cocktails_to_tags",
    primaryKeys = ["cocktail_id", "tag_id"],
    foreignKeys = [
        ForeignKey(
            entity = Cocktail::class,
            parentColumns = arrayOf("cocktail_id"),
            childColumns = arrayOf("cocktail_id"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
        ForeignKey(
            entity = Tag::class,
            parentColumns = arrayOf("tag_id"),
            childColumns = arrayOf("tag_id"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
    ]
)
data class CocktailToTag(
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    @ColumnInfo(name = "tag_id")
    val tagId: Int
)

@Entity(
    tableName = "cocktails_to_tastes",
    primaryKeys = ["cocktail_id", "taste_id"],
    foreignKeys = [
        ForeignKey(
            entity = Cocktail::class,
            parentColumns = arrayOf("cocktail_id"),
            childColumns = arrayOf("cocktail_id"),
            onDelete = CASCADE,
               onUpdate = CASCADE
        ),
        ForeignKey(
            entity = Taste::class,
            parentColumns = arrayOf("taste_id"),
            childColumns = arrayOf("taste_id"),
            onDelete = CASCADE,
            onUpdate = CASCADE
        ),
    ]
)
data class CocktailToTaste(
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    @ColumnInfo(name = "taste_id")
    val tasteId: Int
)
