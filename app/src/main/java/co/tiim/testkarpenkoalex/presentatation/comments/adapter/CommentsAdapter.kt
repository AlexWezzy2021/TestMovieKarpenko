package co.tiim.testkarpenkoalex.presentatation.video_content.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.common.widget.simpleItemCallback
import co.tiim.testkarpenkoalex.data.entity.Video
import co.tiim.testkarpenkoalex.domain.base.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_comment.view.*


/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
class CommentsAdapter :
    ListAdapter<String, CommentsAdapter.ViewHolder>(simpleItemCallback()) {


    class ViewHolder(parent: ViewGroup) : BaseViewHolder<Video>(
        parent,
        R.layout.view_holder_comment
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.txtComment.text = getItem(position)
    }
}
