package mz.co.bilheteira.pixabayimagesearch.ui.imagedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits
import mz.co.bilheteira.pixabayimagesearch.repository.ImageSearchRepository
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    private val repository: ImageSearchRepository
) : ViewModel() {
    private var _uiState = MutableLiveData<ImagesDetailsUIState>()
    val uiState: LiveData<ImagesDetailsUIState> = _uiState

    fun loadHitDetails(id: Int) {
        _uiState.value = ImagesDetailsUIState.Loading
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) { repository.getHit(id) }
            _uiState.value = ImagesDetailsUIState.Content(response)
        }
    }

    sealed class ImagesDetailsUIState {
        object Loading : ImagesDetailsUIState()
        data class Content(val hits: Hits) : ImagesDetailsUIState()
    }
}