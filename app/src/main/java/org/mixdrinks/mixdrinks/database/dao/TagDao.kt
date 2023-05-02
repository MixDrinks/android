package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.mixdrinks.mixdrinks.database.entities.Tag

@Dao
interface TagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAll(tags: List<Tag>)

    @Query("SELECT * FROM tags WHERE tag_id = :id")
    suspend fun getTagById(id: Int): Tag
}
