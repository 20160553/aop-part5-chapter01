package aqper.side_project.aop_part5_chapter01.data.repository

import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity

/**
 * 1. insertToDOList
 * 2. getToDoList
 * 3. updateToDO
 */
interface ToDoRepository {

    suspend fun getToDoList(): List<ToDoEntity>
    suspend fun insertToDoItem(toDoItem: ToDoEntity): Long
    suspend fun insertToDoList(toDoList: List<ToDoEntity>)
    suspend fun updateToDo(toDoEntity: ToDoEntity)
    suspend fun getToDoItem(itemId: Long): ToDoEntity?
    suspend fun deleteAll()
    suspend fun deleteToDoItem(id: Long)
}