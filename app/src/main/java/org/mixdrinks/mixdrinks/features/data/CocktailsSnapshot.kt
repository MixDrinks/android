package org.mixdrinks.mixdrinks.features.data

import androidx.room.Entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.FilterGroupDto
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.dto.TagDto
import org.mixdrinks.dto.TasteDto
import org.mixdrinks.dto.ToolDto

@Serializable
@Entity
data class CocktailsSnapshot(
    @SerialName("cocktails")
    val cocktails: List<CocktailDto>,
    @SerialName("tools")
    val tools: List<ToolDto>,
    @SerialName("goods")
    val goods: List<GoodDto>,
    @SerialName("tags")
    val tags: List<TagDto>,
    @SerialName("tastes")
    val tastes: List<TasteDto>,
    @SerialName("glassware")
    val glassware: List<GlasswareDto>,
    @SerialName("filterGroups")
    val filterGroups: List<FilterGroupDto>
)

