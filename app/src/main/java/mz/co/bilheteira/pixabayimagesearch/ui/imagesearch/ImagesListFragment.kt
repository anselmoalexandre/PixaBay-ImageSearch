package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import mz.co.bilheteira.pixabayimagesearch.R
import mz.co.bilheteira.pixabayimagesearch.databinding.FragmentImagesListBinding
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits
import mz.co.bilheteira.pixabayimagesearch.ui.imagesearch.adapter.ImagesSearchAdapter

@AndroidEntryPoint
class ImagesListFragment : Fragment(R.layout.fragment_images_list) {
    private var _binding: FragmentImagesListBinding? = null
    private val binding: FragmentImagesListBinding
        get() = _binding!!

    private val viewModel: ImagesListViewModel by viewModels()

    private val adapter: ImagesSearchAdapter by lazy {
        ImagesSearchAdapter {
            handleSelectedHit(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentImagesListBinding.bind(view)

        setupAdapter()
        setupObservers()
        setupClickListeners()
    }

    private fun setupAdapter(){
        binding.recycler.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner){
            when(it){
                ImagesListViewModel.ImageListUIState.Loading -> renderLoading()
                is ImagesListViewModel.ImageListUIState.Error -> renderError(it.message)
                is ImagesListViewModel.ImageListUIState.Content -> renderContent(it.hits)
            }
        }
    }

    private fun setupClickListeners() {
        binding.apply {

        }
    }

    private fun handleSelectedHit(hits: Hits) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}