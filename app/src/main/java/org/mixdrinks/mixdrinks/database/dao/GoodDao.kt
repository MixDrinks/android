package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.mixdrinks.mixdrinks.database.entities.Good

@Dao
interface GoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAllGoods(goods: List<Good>)

    @Query("SELECT * FROM goods")
    suspend fun getAllGoods(): List<Good>

    @Query("SELECT * FROM goods WHERE good_id = :id")
    suspend fun getGoodById(id: Int): Good
}
