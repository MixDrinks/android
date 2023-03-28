package org.mixdrinks.mixdrinks.database

import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.dto.GoodRelationDto
import org.mixdrinks.dto.TagDto
import org.mixdrinks.dto.TasteDto
import org.mixdrinks.dto.ToolDto
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation
import org.mixdrinks.mixdrinks.database.entities.Glassware
import org.mixdrinks.mixdrinks.database.entities.Good
import org.mixdrinks.mixdrinks.database.entities.Tag
import org.mixdrinks.mixdrinks.database.entities.Taste
import org.mixdrinks.mixdrinks.database.entities.Tool

fun CocktailDto.toCocktailEntity(): Cocktail {
    return Cocktail(
        cocktailId = this.id.id,
        name = this.name,
        receipt = this.receipt.toString(),
    )
}

fun GoodRelationDto.toGoodRelationDtoEntity(cocktailId: Int): CocktailToGoodRelation {
    return CocktailToGoodRelation(
        cocktailId = cocktailId,
        goodId = this.goodId.id,
        amount = this.amount,
        unit = this.unit
    )
}

fun GoodDto.toGoodEntity(): Good {
    return Good(
        goodId = this.id.id,
        name = this.name,
        about = this.about
    )
}

fun GlasswareDto.toGlasswareEntity(): Glassware {
    return Glassware(
        glasswareId = this.id.value,
        name = this.name,
        about = this.about
    )
}

fun TagDto.toTagEntity(): Tag {
    return Tag(
        tagId = this.id.id,
        name = this.name
    )
}

fun ToolDto.toToolEntity(): Tool {
    return Tool(
        toolId = this.id.id,
        name = this.name,
        about = this.about
    )
}

fun TasteDto.toTasteEntity(): Taste {
    return Taste(
        tasteId = this.id.id,
        name = this.name,
    )
}