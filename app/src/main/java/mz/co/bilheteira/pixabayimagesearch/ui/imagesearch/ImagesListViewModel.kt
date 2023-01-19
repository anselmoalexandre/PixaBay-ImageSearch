package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch

import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mz.co.bilheteira.pixabayimagesearch.domain.data.ImagesDetails
import mz.co.bilheteira.pixabayimagesearch.repository.ImageSearchRepository
import mz.co.bilheteira.pixabayimagesearch.ui.dialogs.ImageDetailsDialog
import mz.co.bilheteira.utils.Event
import mz.co.bilheteira.utils.asEvent
import mz.co.bilheteira.utils.handleThrowable
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ImagesListViewModel @Inject constructor(
    private val repository: ImageSearchRepository
) : ViewModel() {
    private var _uiState = MutableLiveData<ImageListUIState>()
    val uiState: LiveData<ImageListUIState> = _uiState

    private var _interactions = MutableLiveData<Event<ImageListActions>>()
    val interactions: LiveData<Event<ImageListActions>> = _interactions

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Timber.e(exception)
        _uiState.value = ImageListUIState.Error(message = exception.handleThrowable())
    }

    init {
        fetchImageDetailsFromLocalStorage("fruits")
    }

    fun fetchImageDetailsFromLocalStorage(query: String) {
        _uiState.value = ImageListUIState.Loading
        viewModelScope.launch {
            val cachedHits = repository.getLocalImagesDetails()
            if (cachedHits.isNotEmpty()) {
                _uiState.value = ImageListUIState.Content(imagesDetailsList = cachedHits)
            } else fetchFromRemoteStorage(query)
        }
    }

     fun fetchFromRemoteStorage(query: String) {
        _uiState.value = ImageListUIState.Loading
        viewModelScope.launch(exceptionHandler) {
            val response = withContext(Dispatchers.IO) {
                repository.getNetworkImageDetails(query = query)
            }

            if (response.isSuccessful) {
                response.body()?.let {
                    _uiState.value = ImageListUIState.Content(imagesDetailsList = it.hits)
                } ?: _uiState.setValue(ImageListUIState.Error(response.message()))
            } else _uiState.value = ImageListUIState.Error(response.message())
        }
    }

    fun cacheHitsOnLocalStorage(imagesDetailsList: List<ImagesDetails>) = viewModelScope.launch {
        withContext(Dispatchers.IO) { repository.cacheImagesDetails(imagesDetailsList) }
    }

    fun showDialog(imagesDetails: ImagesDetails) {
        val detailsDialogFragment = ImageDetailsDialog.newInstance(
            positiveAction = {
                _uiState.value = ImageListUIState.Success
                _interactions.value = ImageListActions.Navigate(
                    destination = ImagesListFragmentDirections.toImageDetailsFragment(imageId = imagesDetails.id)
                ).asEvent()
            }
        )

        _interactions.value = ImageListActions.DialogNavigate(
            dialogFragment = detailsDialogFragment
        ).asEvent()
    }

    sealed class ImageListActions {
        data class Navigate(val destination: NavDirections) : ImageListActions()
        data class DialogNavigate(val dialogFragment: DialogFragment) : ImageListActions()
    }

    sealed class ImageListUIState {
        object Loading : ImageListUIState()
        object Success : ImageListUIState()
        data class Error(val message: Any) : ImageListUIState()
        data class Content(val imagesDetailsList: List<ImagesDetails>) : ImageListUIState()
    }
}