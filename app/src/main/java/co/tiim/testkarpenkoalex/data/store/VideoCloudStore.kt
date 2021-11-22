package co.tiim.testkarpenkoalex.data.store

import android.content.Context
import co.tiim.testkarpenkoalex.data.api.entity.Video
import co.tiim.testkarpenkoalex.data.readFile
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */
class VideoCloudStore @Inject constructor(
    private val gson: Gson,
    @ApplicationContext private val context: Context
) {
    fun getVideos(): List<Video> =
        gson.fromJson(context.assets.readFile("videos.json"), Array<Video>::class.java).toList()


}
