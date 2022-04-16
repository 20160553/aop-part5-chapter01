package aqper.side_project.aop_part5_chapter01.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity
import aqper.side_project.aop_part5_chapter01.domain.todo.DeleteAllToDoItemUseCase
import aqper.side_project.aop_part5_chapter01.domain.todo.GetToDoListUseCase
import aqper.side_project.aop_part5_chapter01.domain.todo.InsertToDoListUseCase
import aqper.side_project.aop_part5_chapter01.domain.todo.UpdateToDoUseCase
import aqper.side_project.aop_part5_chapter01.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.inject

/**
 * 필요한 UseCase
 * 1. [GetToDoListUseCase]
 * 2. [UpdateTodoUseCase]
 * 3. [DeleteAllToDoItemUseCase]
 */
internal class ListViewModel(
    private val getToDoListUseCase: GetToDoListUseCase,
    private val updateToDoListUseCase: UpdateToDoUseCase,
    private val deleteAllToDoItemUseCase: DeleteAllToDoItemUseCase,
    private val insertToDoListUseCase: InsertToDoListUseCase
): BaseViewModel() {

    private val _toDoListLiveData = MutableLiveData<ToDoListState>(ToDoListState.UnInitialized)
    val toDoListLiveData: LiveData<ToDoListState> = _toDoListLiveData


    override fun fetchData(): Job = viewModelScope.launch {
        _toDoListLiveData.postValue(ToDoListState.Loading)
        insertToDoListUseCase(
            (0 until 10).map {
                ToDoEntity(
                    id = it.toLong(),
                    title = "title $it",
                    description = "description $it",
                    hasCompleted = false
                )
            }
        )
        _toDoListLiveData.postValue(ToDoListState.Success(getToDoListUseCase()))
    }

    fun updateEntity(toDoEntity: ToDoEntity) = viewModelScope.launch {
        updateToDoListUseCase(toDoEntity)
    }

    fun deleteAll() = viewModelScope.launch {
        _toDoListLiveData.postValue(ToDoListState.Loading)
        deleteAllToDoItemUseCase()
        _toDoListLiveData.postValue(ToDoListState.Success(getToDoListUseCase()))
    }
}