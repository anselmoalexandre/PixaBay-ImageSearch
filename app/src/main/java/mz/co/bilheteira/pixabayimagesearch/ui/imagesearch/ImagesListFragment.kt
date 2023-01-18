package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import mz.co.bilheteira.pixabayimagesearch.R
import mz.co.bilheteira.pixabayimagesearch.databinding.FragmentImagesListBinding
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits
import mz.co.bilheteira.pixabayimagesearch.ui.imagesearch.adapter.ImagesSearchAdapter
import mz.co.bilheteira.utils.observeEvent

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

    private lateinit var dialogFragment: DialogFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentImagesListBinding.bind(view)

        setupAdapter()
        setupObservers()
        setupClickListeners()
    }

    private fun setupAdapter() {
        binding.recycler.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                ImagesListViewModel.ImageListUIState.Loading -> renderLoading()
                is ImagesListViewModel.ImageListUIState.Error -> renderError(it.message)
                is ImagesListViewModel.ImageListUIState.Content -> renderContent(it.hits)
            }
        }

        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is ImagesListViewModel.ImageListActions.DialogNavigate -> showDialog(it.dialog)
                is ImagesListViewModel.ImageListActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }

    private fun setupClickListeners() {
        binding.apply {

        }
    }

    private fun handleSelectedHit(hits: Hits) {

    }

    private fun renderLoading() = binding.apply {
        loading.isVisible = true
        searchFab.isGone = true
    }

    private fun renderError(error: Any) = binding.apply {
        loading.isGone = true
        searchFab.isVisible = true
        val errorId = error.toString().toInt()
        showErrorMessage(message = getString(errorId))
    }

    private fun renderContent(hits: List<Hits>){
        binding.apply {
            loading.isGone = true
            searchFab.isVisible = true
        }
        adapter.submitList(hits)
    }

    private fun showDialog(dialog: DialogFragment) {
        dialogFragment = dialog
        dialogFragment.show(parentFragmentManager, dialogFragment.tag)
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        if (::dialogFragment.isInitialized) dialogFragment.dismiss()
    }
}