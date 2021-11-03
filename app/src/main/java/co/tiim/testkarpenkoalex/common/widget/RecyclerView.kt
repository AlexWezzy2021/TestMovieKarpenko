package co.tiim.testkarpenkoalex.common.widget

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */

inline fun <reified T> simpleItemCallback() = object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}


fun <T> ListAdapter<T, *>.forceSubmit(items: List<T>, callback: Runnable? = null) {
    submitList(null) { submitList(items, callback) }
}
