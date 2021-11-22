package co.tiim.testkarpenkoalex.presentatation.ui.detail


import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem
import co.tiim.testkarpenkoalex.presentatation.base.baselineHeight
import com.google.accompanist.glide.rememberGlidePainter

@Composable
fun VideoDetailsScreen(videoItem: VideoItem, onNavIconPressed: () -> Unit = { }) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints(modifier = Modifier.weight(1f)) {
            Surface {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    MovieHeader(
                        scrollState,
                        videoItem,
                        this@BoxWithConstraints.maxHeight
                    )
                    MovieContent(videoItem, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun MovieHeader(
    scrollState: ScrollState,
    videoItem: VideoItem,
    containerHeight: Dp
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = rememberGlidePainter(videoItem.imagePath),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun MovieContent(videoItem: VideoItem, containerHeight: Dp) {

    Column {
        Spacer(modifier = Modifier.height(8.dp))

        Name(videoItem)

        ProfileProperty(stringResource(R.string.company), videoItem.company)

        ProfileProperty(stringResource(R.string.name_video), videoItem.name)

        // Add a spacer that always shows part (320.dp) of the fields list regardless of the device,
        // in order to always leave some content at the top.
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Name(
    videoItem: VideoItem
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        NameVideo(
            videoItem = videoItem,
            modifier = Modifier.baselineHeight(32.dp)
        )
    }
}

@Composable
private fun NameVideo(videoItem: VideoItem, modifier: Modifier = Modifier) {
    Text(
        text = videoItem.name,
        modifier = modifier,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                modifier = Modifier.baselineHeight(24.dp),
                style = MaterialTheme.typography.caption,
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(24.dp),
            style = style
        )
    }
}