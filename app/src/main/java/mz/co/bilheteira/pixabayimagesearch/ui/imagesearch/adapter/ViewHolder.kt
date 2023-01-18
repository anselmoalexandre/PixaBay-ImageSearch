package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import mz.co.bilheteira.pixabayimagesearch.databinding.ItemGenericListBinding
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits

internal class ViewHolder(
    private val binding: ItemGenericListBinding,
    private val currentHits: List<Hits>,
    private val onHitSelectedCallback: (Hits) -> (Unit)
) : RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.setOnClickListener {
            onHitSelectedCallback.invoke(currentHits[adapterPosition])
        }
    }

    fun bind(hits: Hits) = binding.apply {
        photo.load(hits.previewURL)
        name.text = hits.user
        tags.text = hits.tags
    }

    companion object {
        fun create(
            parent: ViewGroup,
            currentHits: List<Hits>,
            onHitSelectedCallback: (Hits) -> (Unit)
        ): ViewHolder {
            val view = ItemGenericListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

            return ViewHolder(view, currentHits, onHitSelectedCallback)
        }
    }
}