package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import mz.co.bilheteira.pixabayimagesearch.repository.ImageSearchRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
internal class ImagesListViewModelTest {
    @MockK(relaxed = true)
    private lateinit var mockkRepository: ImageSearchRepository

    private lateinit var viewModel:ImagesListViewModel

    @get:Rule
    var taskRule:TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        Dispatchers.setMain(dispatcher)
        viewModel = ImagesListViewModel(repository = mockkRepository)
    }

    @Test
    fun `show content state when fetching image details from remote storage`() = runTest {
        // When
        viewModel.fetchFromRemoteStorage(query = "fruits")

        // Then
        dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewModel.uiState.value is ImagesListViewModel.ImageListUIState.Content)
    }

    @Test
    fun `show loading first when getting image details from local storage`() = runTest {
        // Given
        val viewStates = mutableListOf<ImagesListViewModel.ImageListUIState>()
        viewModel.uiState.observeForever {
            viewStates.add(it)
        }

        // When
        viewModel.fetchImageDetailsFromLocalStorage("fruits")

        // Then
        dispatcher.scheduler.advanceUntilIdle()
        assertThat(viewStates[0] is ImagesListViewModel.ImageListUIState.Loading)
    }
}