package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits

internal class ImagesSearchAdapter(
    private val onHitSelectedCallback: (Hits) -> (Unit)
) : ListAdapter<Hits, ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent, currentList, onHitSelectedCallback)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Hits>() {
            override fun areItemsTheSame(oldItem: Hits, newItem: Hits): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Hits, newItem: Hits): Boolean {
                return oldItem.name == newItem.name
            }

        }
    }
}