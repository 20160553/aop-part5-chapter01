package aqper.side_project.aop_part5_chapter01.data.repository

import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity

class TestToDoRepository: ToDoRepository {

    private val toDoList: MutableList<ToDoEntity> = mutableListOf()

    override suspend fun getToDoList(): List<ToDoEntity> {
        return toDoList
    }

    override suspend fun insertToDoList(toDoList: List<ToDoEntity>) {
        this.toDoList.addAll(toDoList)
    }

    override suspend fun updateToDo(toDoItem: ToDoEntity): Boolean {
        val foundToDoEntity = toDoList.find { it.id == toDoItem.id }
        return if (foundToDoEntity == null) false
        else {
            this.toDoList[toDoList.indexOf(foundToDoEntity)] = toDoItem
            true
        }
    }

    override suspend fun getToDoItem(itemId: Long): ToDoEntity? {
        return toDoList.find { it.id == itemId }
    }

    override suspend fun deleteAll() {
        toDoList.clear()
    }

}