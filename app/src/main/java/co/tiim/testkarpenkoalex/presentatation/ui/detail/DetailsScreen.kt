package co.tiim.testkarpenkoalex.presentatation.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem
import co.tiim.testkarpenkoalex.presentatation.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */

@AndroidEntryPoint
open class DetailsScreen: AppCompatActivity() {

    private val videoItem: VideoItem by lazy {
        intent?.getParcelableExtra(VIDEO_ID)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                VideoDetailsScreen(videoItem)
            }
        }
    }

    companion object {
        private const val VIDEO_ID = "video_id"
        fun newIntent(context: Context, videoItem: VideoItem) =
            Intent(context, DetailsScreen::class.java).apply {
                putExtra(VIDEO_ID, videoItem)
            }
    }
}