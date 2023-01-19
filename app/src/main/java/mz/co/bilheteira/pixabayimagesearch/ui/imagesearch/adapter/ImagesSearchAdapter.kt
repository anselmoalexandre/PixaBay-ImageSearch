package mz.co.bilheteira.pixabayimagesearch.ui.imagesearch.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import mz.co.bilheteira.pixabayimagesearch.domain.data.ImagesDetails

internal class ImagesSearchAdapter(
    private val onImageSelectedCallback: (ImagesDetails) -> (Unit)
) : ListAdapter<ImagesDetails, ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent, currentList, onImageSelectedCallback)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ImagesDetails>() {
            override fun areItemsTheSame(oldItem: ImagesDetails, newItem: ImagesDetails): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ImagesDetails, newItem: ImagesDetails): Boolean {
                return oldItem.user == newItem.user
            }

        }
    }
}