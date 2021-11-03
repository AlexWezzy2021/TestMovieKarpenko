package co.tiim.testkarpenkoalex.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */

data class VideoContent constructor(
    val list: List<Video>
)

data class Video constructor(
    @SerializedName("video_description") val videoDescription: String,
    @SerializedName("video_path") val videoPath: String,
    @SerializedName("video_number_likes") val videoNumLikes: Int,
    @SerializedName("video_number_comments") val videoNumComments: Int,
    @SerializedName("user_id") val videoUserId: String,
    @SerializedName("user_name") val videoUserName: String,
    @SerializedName("user_image_path") val videoUserImagePath: String,
)
