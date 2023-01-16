package mz.co.bilheteira.pixabayimagesearch.ui.imagedetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import mz.co.bilheteira.pixabayimagesearch.R
import mz.co.bilheteira.pixabayimagesearch.databinding.FragmentImageDetailsBinding

@AndroidEntryPoint
class ImageDetailsFragment : Fragment(R.layout.fragment_image_details) {
    private var _binding: FragmentImageDetailsBinding? = null
    private val binding: FragmentImageDetailsBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentImageDetailsBinding.bind(view)

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