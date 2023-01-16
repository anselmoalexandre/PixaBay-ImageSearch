package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import mz.co.bilheteira.pixabayimagesearch.R
import mz.co.bilheteira.pixabayimagesearch.databinding.FragmentImagesListBinding

@AndroidEntryPoint
class ImagesListFragment : Fragment(R.layout.fragment_images_list) {
    private var _binding: FragmentImagesListBinding? = null
    private val binding: FragmentImagesListBinding
        get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentImagesListBinding.bind(view)

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers() {}

    private fun setupClickListeners() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}