package org.mixdrinks.mixdrinks.features.data

data class DetailGood(
    val id: Int,
    val name: String,
    val about: String,

)
data class GoodType(
    val id: Int,
    val type: Type
) {
    enum class Type {
        GOOD, GLASSWARE, TOOL;
        companion object {
            fun fromString(value: String) = Type.values().first() { it.toString() == value }
        }
    }
}

