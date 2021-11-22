package co.tiim.testkarpenkoalex.data.store

import android.content.Context
import android.content.SharedPreferences
import co.tiim.testkarpenkoalex.common.delegate.StringPreference
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */
class LocalDataStore @Inject constructor(@ApplicationContext context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("karpenko.app", Context.MODE_PRIVATE)

    var profile by StringPreference(preferences, PROFILE)


    private companion object {
        const val PROFILE = "Profile"
    }
}
