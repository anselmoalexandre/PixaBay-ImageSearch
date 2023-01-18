package mz.co.bilheteira.pixabayimagesearch.ui.imagedetails

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import mz.co.bilheteira.pixabayimagesearch.R
import mz.co.bilheteira.pixabayimagesearch.databinding.FragmentImageDetailsBinding
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits

@AndroidEntryPoint
class ImageDetailsFragment : Fragment(R.layout.fragment_image_details) {
    private var _binding: FragmentImageDetailsBinding? = null
    private val binding: FragmentImageDetailsBinding
        get() = _binding!!

    private val args: ImageDetailsFragmentArgs by navArgs()

    private val viewModel: ImageDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentImageDetailsBinding.bind(view)

        loadHitDetails()
        setupObservers()
    }

    private fun loadHitDetails() = viewModel.loadHitDetails(args.hitId)

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner){
            when(it){
                ImageDetailsViewModel.ImagesDetailsUIState.Loading -> renderLoading()
                is ImageDetailsViewModel.ImagesDetailsUIState.Content -> renderContent(it.hits)
            }
        }
    }

    private fun renderLoading() = binding.apply {
        loading.isVisible = true
    }

    private fun renderContent(hits: Hits){
        binding.apply {
            loading.isGone = true

            user.text = hits.user
            comments.text = "${hits.comments}"
            downloads.text = "${hits.downloads}"
            "${hits.likes}".also {
                likes.text = it
            }
            tags.text = hits.tags
            photo.load(hits.largeImageURL)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}