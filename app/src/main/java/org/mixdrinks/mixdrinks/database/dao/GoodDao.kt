package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.mixdrinks.dto.GoodDto
import org.mixdrinks.mixdrinks.database.entities.Good

@Dao
interface GoodDao {
    suspend fun insertAllGoods(goods: List<GoodDto>) {
        addAll(goods.map { good ->
            Good(
                goodId = good.id.id,
                name = good.name,
                about = good.about
            )
        })
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAll(goods: List<Good>)

    @Query("SELECT * FROM goods WHERE good_id = :id")
    suspend fun getGoodById(id: Int): Good
}

