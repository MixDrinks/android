package org.mixdrinks.mixdrinks.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.mixdrinks.dto.ToolDto
import org.mixdrinks.mixdrinks.database.entities.Tool

@Dao
interface ToolDao {
    suspend fun insertAllTools(tools: List<ToolDto>) {
        addAll(tools.map { tool ->
            Tool(
                toolId = tool.id.id,
                name = tool.name,
                about = tool.about
            )
        })
    }
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Transaction
    suspend fun addAll(tools: List<Tool>)

    @Query("SELECT * FROM tools")
    suspend fun getAllTools(): List<Tool>

    @Query("SELECT * FROM tools WHERE tool_id = :id")
    suspend fun getToolById(id: Int): Tool
}

