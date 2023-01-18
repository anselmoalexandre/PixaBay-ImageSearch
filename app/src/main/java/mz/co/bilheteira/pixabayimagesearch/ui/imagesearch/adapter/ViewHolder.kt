package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import mz.co.bilheteira.pixabayimagesearch.databinding.ItemGenericListBinding
import mz.co.bilheteira.pixabayimagesearch.domain.data.ImagesDetails

internal class ViewHolder(
    private val binding: ItemGenericListBinding,
    private val imagesDetailsList: List<ImagesDetails>,
    private val onImageSelectedCallback: (ImagesDetails) -> (Unit)
) : RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.setOnClickListener {
            onImageSelectedCallback.invoke(imagesDetailsList[adapterPosition])
        }
    }

    fun bind(imagesDetails: ImagesDetails) = binding.apply {
        photo.load(imagesDetails.previewURL)
        name.text = imagesDetails.user
        tags.text = imagesDetails.tags
    }

    companion object {
        fun create(
            parent: ViewGroup,
            imagesDetailsList: List<ImagesDetails>,
            onImageSelectedCallback: (ImagesDetails) -> (Unit)
        ): ViewHolder {
            val view = ItemGenericListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return ViewHolder(view, imagesDetailsList, onImageSelectedCallback)
        }
    }
}