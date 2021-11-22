package co.tiim.testkarpenkoalex.data.api.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */

data class Video constructor(
    @SerializedName("id") val id: Int,
    @SerializedName("video_name") val videoName: String,
    @SerializedName("image_path") val imagePath: String,
    @SerializedName("company_name") val companyName: String,
)
