package co.tiim.testkarpenkoalex.domain.usecases.video

import co.tiim.testkarpenkoalex.data.store.VideoLocalStore
import co.tiim.testkarpenkoalex.domain.base.BaseUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
class VideoUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    private val videoLocalStore: VideoLocalStore,
) : BaseUseCase(dispatcher) {

    suspend fun launch() = wrapResult {
        videoLocalStore.getVideos()
    }
}