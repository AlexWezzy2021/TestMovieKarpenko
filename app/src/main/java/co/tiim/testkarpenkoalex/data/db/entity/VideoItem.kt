package co.tiim.testkarpenkoalex.data.db.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Alexander Karpenko on 20.11.2021.
 * java.karpenko@gmail.com
 */
@Parcelize
class VideoItem constructor(
    val id: Int,
    val name: String,
    val company: String,
    val imagePath: String,
    var checked: Boolean
): Parcelable
