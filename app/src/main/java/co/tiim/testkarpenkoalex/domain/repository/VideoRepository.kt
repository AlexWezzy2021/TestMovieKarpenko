package co.tiim.testkarpenkoalex.domain.repository

import co.tiim.testkarpenkoalex.data.db.entity.VideoItem
import co.tiim.testkarpenkoalex.data.mapper.VideoMapper.toData
import co.tiim.testkarpenkoalex.data.store.VideoCloudStore
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */
class VideoRepository @Inject constructor(
    private val portfolioLocalStore: VideoCloudStore,
) {

    fun getVideoList(): List<VideoItem> =
        requireNotNull(portfolioLocalStore.getVideos().toData())

}
