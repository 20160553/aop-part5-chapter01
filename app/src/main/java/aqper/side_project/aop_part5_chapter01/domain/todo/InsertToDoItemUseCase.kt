package aqper.side_project.aop_part5_chapter01.domain.todo

import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity
import aqper.side_project.aop_part5_chapter01.data.repository.ToDoRepository
import aqper.side_project.aop_part5_chapter01.domain.UseCase

internal class InsertToDoItemUseCase(
    private val toDoRepository: ToDoRepository
): UseCase {
    suspend operator fun invoke(toDoItem: ToDoEntity): Long {
        return toDoRepository.insertToDoItem(toDoItem)
    }
}