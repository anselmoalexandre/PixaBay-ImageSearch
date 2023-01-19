package mz.co.bilheteira.pixabayimagesearch.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import mz.co.bilheteira.pixabayimagesearch.databinding.DialogSearchInputBinding
import mz.co.bilheteira.pixabayimagesearch.domain.data.SearchInputCallbackHandler
import java.io.Serializable

class SearchInputDialog : DialogFragment() {
    private var _binding: DialogSearchInputBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var searchInputCallback: SearchInputCallbackHandler

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            it.window?.setLayout(width, height)
        }
    }

    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            searchInputCallback =
                it.getSerializable(SEARCH_INPUT_CALLBACK) as SearchInputCallbackHandler
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        isCancelable = false
        _binding = DialogSearchInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        setupClickListeners()
    }

    private fun setupObservers(){
        binding.apply {
            searchInput.addTextChangedListener {
                it?.let {
                    primaryButton.isEnabled = validateInput()
                }
            }
        }
    }

    private fun setupClickListeners() {
        binding.apply {
            viewClose.setOnClickListener { dismiss() }

            primaryButton.setOnClickListener {
                searchInputCallback(searchInput.text.toString())
                dismiss()
            }
        }
    }

    private fun validateInput(): Boolean {
        binding.apply {
            var isValid = true
            if (searchInput.text.toString().trim().isEmpty()) isValid = false
            return isValid
        }
    }

    companion object {
        private const val SEARCH_INPUT_CALLBACK = "search_input"
        fun newInstance(
            searchInput: SearchInputCallbackHandler
        ) = SearchInputDialog().apply {
            arguments = Bundle().apply {
                putSerializable(SEARCH_INPUT_CALLBACK, searchInput as Serializable)
            }
        }
    }
}