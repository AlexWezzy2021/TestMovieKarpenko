package co.tiim.testkarpenkoalex.data.store

import android.content.Context
import co.tiim.testkarpenkoalex.data.entity.Profile
import co.tiim.testkarpenkoalex.data.readFile
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
class ProfileLocalStore @Inject constructor(
    private val gson: Gson,
    @ApplicationContext private val context: Context,
    private val localStore: LocalDataStore
) {
    fun getProfile(): Profile? {
        val profile = localStore.profile
        return if (profile.isEmpty()) {
            val profileFromFile = gson.fromJson(context.assets.readFile("user.json"), Profile::class.java)
            saveProfile(profileFromFile)
            profileFromFile
        } else {
            gson.fromJson(profile, Profile::class.java)
        }
    }

    fun saveProfile(profile: Profile) {
        localStore.profile = gson.toJson(profile)
    }


}
