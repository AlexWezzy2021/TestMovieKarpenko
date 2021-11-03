package co.tiim.testkarpenkoalex.presentatation.video_content

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.tiim.testkarpenkoalex.data.entity.Video
import co.tiim.testkarpenkoalex.domain.usecases.video.VideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
@HiltViewModel
class VideoMediaViewModel @Inject constructor(
    private val videoUseCase: VideoUseCase
) : ViewModel() {

    val videoContent = MutableLiveData<List<Video>>()


    fun getVideos() {
        viewModelScope.launch {
            videoUseCase.launch().fold(
                onSuccess = {
                    videoContent.value = it
                },
                onFailure = {
                    TODO("Handle an error")
                }
            )
        }
    }

}