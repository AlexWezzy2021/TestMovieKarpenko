package co.tiim.testkarpenkoalex.presentatation.video_content

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem
import co.tiim.testkarpenkoalex.presentatation.ui.theme.graySurface
import co.tiim.testkarpenkoalex.presentatation.ui.theme.typography
import com.google.accompanist.glide.rememberGlidePainter

/**
 * Created by Alexander Karpenko on 20.11.2021.
 * java.karpenko@gmail.com
 */

@Composable
fun MovieListItem(
    movie: VideoItem,
    navigateToProfile: ((VideoItem) -> Unit?)? = null,
    viewModel: VideoMediaViewModel? = null,
    isNeedToShowLikedView: Boolean = true
) {


    Card(
        modifier = Modifier
            .padding(horizontal = 18.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = graySurface,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {

        Row(Modifier.clickable {
            navigateToProfile?.let { it(movie) }
        }) {

            MovieImage(movie)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {


                Text(text = movie.name, style = typography.h6, color = Color.White)
                Text(text = movie.company, style = typography.caption, color = Color.White)
                if (isNeedToShowLikedView) {
                Row {
                    Text(text = stringResource(R.string.like), style = typography.h6, color = Color.White)

                        val state = remember { mutableStateOf(false) }
                        Checkbox(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .fillMaxWidth(),
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.White,
                                checkmarkColor = Color.Black,

                                uncheckedColor = Color.White.copy(alpha = 0.3f)

                            ), checked = state.value, onCheckedChange = {
                                state.value = it
                                viewModel?.editLikedItem(it, movie)
                            })
                    }
                }
            }
        }
    }
}


@Composable
private fun MovieImage(movie: VideoItem) {
    Image(
        painter = rememberGlidePainter(movie.imagePath),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(10.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}