package aqper.side_project.aop_part5_chapter01.data.repository

import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity

class DefaultToDoRepository: ToDoRepository {
    override suspend fun getToDoList(): List<ToDoEntity> {
        TODO()
    }

    override suspend fun insertToDoItem(toDoItem: ToDoEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        TODO()
    }

    override suspend fun updateToDo(toDoEntity: ToDoEntity): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getToDoItem(itemId: Long): ToDoEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAll() {
        TODO("Not yet implemented")
    }
}