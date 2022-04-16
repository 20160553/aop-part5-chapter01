package aqper.side_project.aop_part5_chapter01.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity
import aqper.side_project.aop_part5_chapter01.data.local.db.dao.ToDoDao

@Database(
    entities = [ToDoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ToDoDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "ToDoDatabase.db"
    }

    abstract fun toDoDao(): ToDoDao
}