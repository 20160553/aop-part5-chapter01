package aqper.side_project.aop_part5_chapter01.viewmodel.todo

import aqper.side_project.aop_part5_chapter01.data.entity.ToDoEntity
import aqper.side_project.aop_part5_chapter01.domain.todo.InsertToDoItemUseCase
import aqper.side_project.aop_part5_chapter01.presentation.detail.DetailMode
import aqper.side_project.aop_part5_chapter01.presentation.detail.DetailViewModel
import aqper.side_project.aop_part5_chapter01.presentation.detail.ToDoDetailState
import aqper.side_project.aop_part5_chapter01.viewmodel.ViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.test.inject

/**
 * [DetailViewModel]을 테스트하기 위한 Unit Test class
 *
 * 1. initData()
 * 2. test viewModel fetch
 * 3. test delete todo
 * 4. test update todo
 *
 */
@ExperimentalCoroutinesApi
internal class DetailViewModelTest: ViewModelTest() {

    private val id = 1L

    private val detailViewModel by inject<DetailViewModel> { parametersOf(DetailMode.DETAIL, id) }
    private val insertToDoItemUseCase: InsertToDoItemUseCase by inject()

    private val todo = ToDoEntity(
        id = id,
        title = "title $id",
        description = "description $id",
        hasCompleted = false
    )

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertToDoItemUseCase(todo)
    }

    @Test
    fun `test viewModel fetch`() = runBlockingTest {
        val testObservable = detailViewModel.toDoDetailLiveData.test()

        detailViewModel.fetchData()
        testObservable.assertValueSequence(
            listOf(
                ToDoDetailState.UnInitialized,
                ToDoDetailState.Loading,
                ToDoDetailState.Success(todo)
            )
        )
    }


}