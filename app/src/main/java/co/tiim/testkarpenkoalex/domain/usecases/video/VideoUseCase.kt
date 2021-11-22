package co.tiim.testkarpenkoalex.domain.usecases.video

import co.tiim.testkarpenkoalex.domain.base.BaseUseCase
import co.tiim.testkarpenkoalex.domain.repository.VideoRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */
class VideoUseCase @Inject constructor(
    dispatcher: CoroutineDispatcher,
    private val videoRepository: VideoRepository,
) : BaseUseCase(dispatcher) {

    suspend fun launch() = wrapResult {
        videoRepository.getVideoList()
    }
}