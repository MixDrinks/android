package org.mixdrinks.mixdrinks.database

import org.mixdrinks.dto.CocktailDto
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.dto.GoodRelationDto
import org.mixdrinks.mixdrinks.database.entities.Cocktail
import org.mixdrinks.mixdrinks.database.entities.CocktailToGoodRelation
import org.mixdrinks.mixdrinks.database.entities.Glassware
import org.mixdrinks.mixdrinks.database.entities.Good

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