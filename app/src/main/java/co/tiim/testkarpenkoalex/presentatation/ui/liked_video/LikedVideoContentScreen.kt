package co.tiim.testkarpenkoalex.presentatation.ui.liked_video

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem
import co.tiim.testkarpenkoalex.presentatation.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */
@AndroidEntryPoint
class LikedVideoContentScreen : AppCompatActivity() {


    private val videoItem: ArrayList<VideoItem> by lazy {
        intent?.getParcelableArrayListExtra(VIDEOS_LIKED_LIST)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Scaffold(
                    content = {
                        likedVideoContent(videoItem)
                    }
                )
            }
        }
    }

    companion object {
        private const val VIDEOS_LIKED_LIST = "video_liked_list"
        fun newIntent(context: Context, videoItem: ArrayList<VideoItem>) =
            Intent(context, LikedVideoContentScreen::class.java).apply {
                putParcelableArrayListExtra(VIDEOS_LIKED_LIST, videoItem)
            }
    }
}
