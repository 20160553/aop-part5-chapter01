package aqper.side_project.aop_part5_chapter01.di

import aqper.side_project.aop_part5_chapter01.data.repository.TestToDoRepository
import aqper.side_project.aop_part5_chapter01.data.repository.ToDoRepository
import aqper.side_project.aop_part5_chapter01.domain.todo.*
import aqper.side_project.aop_part5_chapter01.presentation.detail.DetailMode
import aqper.side_project.aop_part5_chapter01.presentation.detail.DetailViewModel
import aqper.side_project.aop_part5_chapter01.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    //ViewModel
    viewModel { ListViewModel(get(), get(), get()) }
    viewModel { (detailMode: DetailMode, id: Long) ->
        DetailViewModel(
            detailMode = detailMode,
            id = id,
            get(),
            get()
        )
    }

    //UseCase
    factory { GetToDoListUseCase(get())}
    factory { InsertToDoItemUseCase(get()) }
    factory { InsertToDoListUseCase(get()) }
    factory { UpdateToDoListUseCase(get()) }
    factory { GetToDoItemUseCase(get()) }
    factory { DeleteAllToDoItemUseCase(get())}
    factory { DeleteToDoItemUseCase(get())}

    //Repository
    single<ToDoRepository> { TestToDoRepository() }

}