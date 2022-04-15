package aqper.side_project.aop_part5_chapter01.di

import aqper.side_project.aop_part5_chapter01.data.repository.TestToDoRepository
import aqper.side_project.aop_part5_chapter01.data.repository.ToDoRepository
import aqper.side_project.aop_part5_chapter01.domain.todo.*
import aqper.side_project.aop_part5_chapter01.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    //ViewModel
    viewModel { ListViewModel(get(), get(), get()) }

    //UseCase
    factory { GetToDoListUseCase(get())}
    factory { InsertToDoListUseCase(get()) }
    factory { UpdateToDoListUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get())}

    //Repository
    single<ToDoRepository> { TestToDoRepository() }

}