package org.mixdrinks.mixdrinks.features.data

import androidx.room.ColumnInfo
import org.mixdrinks.dto.CocktailId
import org.mixdrinks.dto.GlasswareId
import org.mixdrinks.dto.GoodId
import org.mixdrinks.dto.TagId
import org.mixdrinks.dto.TasteId
import org.mixdrinks.dto.ToolId

data class CocktailFull(
    val id: CocktailId,
    val name: String,
    val receipt: List<String>,
    val goods: List<Good>,
    val tools: List<Tool>,
    val tags: List<Tag>,
    val tastes: List<Taste>,
    val glassware: Glassware
) {
    data class Good(
        val id: GoodId,
        val name: String,
        val amount: Int,
        val unit: String
    )
    data class Tool(
        val id: ToolId,
        val name: String,
    )
    data class Tag(
        val id: TagId,
        val name: String,
    )

    data class Taste(
        val id: TasteId,
        val name: String,
    )

    data class Glassware(
        val id: GlasswareId,
        val name: String,
    )
}



data class CocktailShort(
    @ColumnInfo(name = "cocktail_id")
    val cocktailId: Int,
    val name: String,
)

