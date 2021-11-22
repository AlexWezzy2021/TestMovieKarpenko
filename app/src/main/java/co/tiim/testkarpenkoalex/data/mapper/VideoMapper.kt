package co.tiim.testkarpenkoalex.data.mapper

import co.tiim.testkarpenkoalex.data.api.entity.Video
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem

/**
 * Created by Alexander Karpenko on 20.11.2021.
 * java.karpenko@gmail.com
 */
object VideoMapper {

    fun List<Video>.toData(): List<VideoItem> {
        return map {
            VideoItem(
                id = it.id,
                name = it.videoName,
                imagePath = it.imagePath,
                company = it.companyName,
                checked = false
            )
        }
    }
}