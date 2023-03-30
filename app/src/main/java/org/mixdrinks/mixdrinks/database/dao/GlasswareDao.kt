package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.mixdrinks.dto.GlasswareDto
import org.mixdrinks.mixdrinks.database.entities.Glassware

@Dao
interface GlasswareDao {
    suspend fun insertAllGlasswares(glasswares: List<GlasswareDto>) {
        addAll(glasswares.map { glassware ->
            Glassware(
                glasswareId = glassware.id.value,
                name = glassware.name,
                about = glassware.about
            )
        })
    }
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAll(glasswares: List<Glassware>)

    @Query("SELECT * FROM glasswares")
    suspend fun getAllGlasswares(): List<Glassware>

    @Query("SELECT * FROM glasswares WHERE glassware_id = :id")
    suspend fun getById(id: Int): Glassware

}
