package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.mixdrinks.mixdrinks.database.entities.Tag
import org.mixdrinks.mixdrinks.database.entities.Taste

@Dao
interface TasteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllTastes(taste: List<Taste>)

    @Query("SELECT * FROM tastes")
    suspend fun getAllTastes(): List<Taste>

    @Query("SELECT * FROM tastes WHERE taste_id = :id")
    suspend fun getTasteById(id: Int): Taste
}
