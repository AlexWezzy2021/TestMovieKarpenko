package co.tiim.testkarpenkoalex.data.api.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */

data class Profile(
    @SerializedName("user_name") val userName: String,
    @SerializedName("user_title") val userTitle: String?,
    @SerializedName("user_local_image") val userLocalImage: String,
    @SerializedName("user_videos") val userVideos: Int?,
    @SerializedName("user_following") val userFollowing: Int,
    @SerializedName("user_fans") val userFans: Int,
    @SerializedName("user_hearts") val userHearts: Int,
)