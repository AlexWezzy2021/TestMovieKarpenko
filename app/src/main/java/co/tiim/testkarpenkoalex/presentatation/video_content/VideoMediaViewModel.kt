package co.tiim.testkarpenkoalex.presentatation.video_content

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import co.tiim.testkarpenkoalex.data.db.entity.VideoItem
import co.tiim.testkarpenkoalex.domain.base.BaseViewModel
import co.tiim.testkarpenkoalex.domain.usecases.video.VideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */
@HiltViewModel
class VideoMediaViewModel @Inject constructor(
    private val videoUseCase: VideoUseCase
) : BaseViewModel() {

    val videoContent = MutableLiveData<List<VideoItem>>()
    val videoLikedContent = MutableLiveData<List<VideoItem>>()
    private val likedList = mutableListOf<VideoItem>()

    init {
        getVideosList()
    }


    private fun getVideosList() {
        viewModelScope.launch {
            videoUseCase.launch().fold(
                onSuccess = {
                    videoContent.value = it
                },
                onFailure = error::setValue
            )
        }
    }

    fun editLikedItem(isChecked: Boolean, movie: VideoItem) {
        if (isChecked) {
            likedList.add(movie)
        } else {
            likedList.removeIf { movie.id == it.id }
        }

    }

    fun onLikedVideoClick() {
        videoLikedContent.value = likedList
    }
}