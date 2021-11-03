package co.tiim.testkarpenkoalex.domain.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */

abstract class BaseViewHolder<T : Any>(parent: ViewGroup, @LayoutRes layoutRes: Int) :
    RecyclerView.ViewHolder(parent.inflate(layoutRes)) {

    lateinit var item: T; private set
    protected val context: Context = itemView.context

    open fun bind(item: T) {
        this.item = item
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
