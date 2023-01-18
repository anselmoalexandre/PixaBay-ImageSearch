package mz.co.bilheteira.pixabayimagesearch.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import mz.co.bilheteira.pixabayimagesearch.databinding.DialogImageDetailsBinding
import mz.co.bilheteira.pixabayimagesearch.domain.data.PositiveActionCallbackHandler
import java.io.Serializable

class ImageDetailsDialog : DialogFragment() {
    private var _binding: DialogImageDetailsBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var positiveActionCallback: PositiveActionCallbackHandler

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
            positiveActionCallback = it.getSerializable(POSITIVE_ACTION_CALLBACK) as PositiveActionCallbackHandler
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        isCancelable = false
        _binding = DialogImageDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.apply {
            primaryButton.setOnClickListener {
                positiveActionCallback()
                dismiss()
            }
            viewClose.setOnClickListener { dismiss() }
            secondaryButton.setOnClickListener { dismiss() }
        }
    }

    companion object {
        private const val POSITIVE_ACTION_CALLBACK = "positiveAction"
        fun newInstance(
            positiveAction: PositiveActionCallbackHandler
        ) = ImageDetailsDialog().apply {
            arguments = Bundle().apply {
                putSerializable(POSITIVE_ACTION_CALLBACK, positiveAction as Serializable)
            }
        }
    }
}