package co.tiim.testkarpenkoalex.presentatation.video_content.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.common.widget.simpleItemCallback
import co.tiim.testkarpenkoalex.data.entity.Video
import co.tiim.testkarpenkoalex.domain.base.BaseViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_video.*
import kotlinx.android.synthetic.main.view_holder_video.view.*


/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
class MediaAdapter(val click: (Video) -> Unit, private val shareLink: (String) -> Unit, private val commentClick: () -> Unit) :
    ListAdapter<Video, MediaAdapter.ViewHolder>(simpleItemCallback()) {


    class ViewHolder(parent: ViewGroup) : BaseViewHolder<Video>(
        parent,
        R.layout.view_holder_video
    ) {
        @SuppressLint("RestrictedApi")
        override fun bind(item: Video) {
            super.bind(item)

            itemView.txtVideoDescription.run {
                text = item.videoDescription
            }
            itemView.txtVideoUserName.run {
                text = context.getString(R.string.user_name_video, item.videoUserName)
            }

            itemView.txtLikesCount.run {
                text = context.getString(R.string.likes_counter, item.videoNumLikes)
            }

            itemView.txtVideoCommentCount.run {
                text = context.getString(R.string.video_comments, item.videoNumComments)
            }

            itemView.imgPreview.run {
                Glide.with(this)
                    .load(item.videoPath)
                    .placeholder(R.drawable.loading)
                    .into(this)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent).apply {
            itemView.setOnClickListener {
                click(item)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoItem = getItem(position)
        holder.bind(videoItem)

        holder.itemView.imgShare.setOnClickListener {
            shareLink(videoItem.videoPath)
        }

        holder.itemView.btComment.setOnClickListener {
            commentClick()
        }
    }
}
