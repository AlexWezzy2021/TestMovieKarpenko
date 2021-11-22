package co.tiim.testkarpenkoalex.presentatation.video_content

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem

@Composable
fun VideoMediaContent(navigateToMovie: (VideoItem) -> Unit, viewModel: VideoMediaViewModel) {
    val lazyListState = rememberLazyListState()
    var scrolledY = 0f
    var previousOffset = 0
    viewModel.videoContent.observeAsState().value?.let {
        LazyColumn(
            Modifier.fillMaxSize(),
            lazyListState,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {

            item {
                Image(
                    painter = painterResource(id = R.drawable.header),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .graphicsLayer {
                            scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                            translationY = scrolledY * 0.5f
                            previousOffset = lazyListState.firstVisibleItemScrollOffset
                        }
                        .height(140.dp)
                        .fillMaxWidth()
                )
            }
            items(
                items = it,
                itemContent = {
                    MovieListItem(movie = it, navigateToMovie, viewModel)
                }
            )
        }
    }
}