package co.tiim.testkarpenkoalex.presentatation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem
import co.tiim.testkarpenkoalex.presentatation.ui.detail.DetailsScreen
import co.tiim.testkarpenkoalex.presentatation.ui.liked_video.LikedVideoContentScreen
import co.tiim.testkarpenkoalex.presentatation.ui.theme.MyTheme
import co.tiim.testkarpenkoalex.presentatation.video_content.VideoMediaContent
import co.tiim.testkarpenkoalex.presentatation.video_content.VideoMediaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: VideoMediaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp {
                    startActivity(DetailsScreen.newIntent(this, it))
                }
            }
            viewModel.videoLikedContent.observe(this, {
                startActivity(LikedVideoContentScreen.newIntent(this, it.toMutableList() as ArrayList<VideoItem>))
            })
        }
    }

    @Composable
    fun MyApp(navigateToProfile: (VideoItem) -> Unit) {
        Scaffold(
            content = {
                VideoMediaContent(navigateToMovie = navigateToProfile, viewModel = viewModel)
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Button(
                        onClick = { viewModel.onLikedVideoClick() },
                        elevation = ButtonDefaults.elevation()
                    ) {
                        Text(text = stringResource(R.string.liked_video))
                    }
                }
            }
        )
    }
}