package co.tiim.testkarpenkoalex.presentatation.video_content

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.common.lifecycle.observe
import co.tiim.testkarpenkoalex.data.entity.Video
import co.tiim.testkarpenkoalex.presentatation.base.BaseFragment
import co.tiim.testkarpenkoalex.presentatation.comments.CommentActivity
import co.tiim.testkarpenkoalex.presentatation.util.share
import co.tiim.testkarpenkoalex.presentatation.video_content.adapter.MediaAdapter
import kotlinx.android.synthetic.main.fragment_video_media.*

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
class VideoMediaScreen : BaseFragment() {

    private val viewModel: VideoMediaViewModel by viewModels()

    override val layoutRes = R.layout.fragment_video_media

    private val mediaAdapter = MediaAdapter(
        ::onMediaClick, ::shareLink, ::commentClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = mediaAdapter

        observe(viewModel.videoContent) {
            progress.isVisible = false
            mediaAdapter.submitList(it) {
                mediaAdapter.notifyDataSetChanged()
            }
        }
        viewModel.getVideos()
    }

    private fun commentClick() = CommentActivity.launch(requireContext())

    private fun shareLink(shareLink: String) = share(requireActivity(), shareLink)

    private fun onMediaClick(video: Video) = PlayerActivity.launch(requireContext(), video.videoPath)


}