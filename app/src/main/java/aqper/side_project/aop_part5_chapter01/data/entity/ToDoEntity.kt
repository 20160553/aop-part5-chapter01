package aqper.side_project.aop_part5_chapter01.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoEntity(
    @PrimaryKey val id: Long = 0,
    val title: String,
    val description: String,
    val hasCompleted: Boolean = false
)
