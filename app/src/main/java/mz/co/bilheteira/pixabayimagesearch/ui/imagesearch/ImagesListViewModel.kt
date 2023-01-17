package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ImagesListViewModel : ViewModel() {
    private var _uiState = MutableLiveData<ImageListUIState>()
    val uiState:LiveData<ImageListUIState> = _uiState

    sealed class ImageListActions {
        data class Navigate(val destination: NavDirections) : ImageListActions()
    }

    sealed class ImageListUIState {
        object Loading : ImageListUIState()
        object Success : ImageListUIState()
        data class Error(val message: String) : ImageListUIState()
        data class Content(val content: String) : ImageListUIState()
    }
}