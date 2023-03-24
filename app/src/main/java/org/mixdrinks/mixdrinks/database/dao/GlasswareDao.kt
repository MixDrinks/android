package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.mixdrinks.mixdrinks.database.entities.Glassware
import org.mixdrinks.mixdrinks.database.entities.Good

@Dao
interface GlasswareDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAll(glassware: List<Glassware>)

    @Query("SELECT * FROM glasswares")
    suspend fun getAllGlasswares(): List<Glassware>

    @Query("SELECT * FROM glasswares WHERE glassware_id = :id")
    suspend fun getById(id: Int): Glassware

}
