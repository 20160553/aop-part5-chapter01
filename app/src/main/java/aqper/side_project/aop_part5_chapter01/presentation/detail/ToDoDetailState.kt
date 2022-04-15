package aqper.side_project.aop_part5_chapter01.presentation.detail

import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity

sealed class ToDoDetailState {
    object UnInitialized: ToDoDetailState()
    object Loading: ToDoDetailState()

    data class Success(
        val toDoItem: ToDoEntity
    ): ToDoDetailState()

    object Delete: ToDoDetailState()
    object Modify: ToDoDetailState()
    object Error: ToDoDetailState()
    object Write: ToDoDetailState()
}