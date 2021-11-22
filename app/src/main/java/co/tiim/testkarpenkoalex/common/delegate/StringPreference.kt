package co.tiim.testkarpenkoalex.common.delegate

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by Alexander Karpenko on 22.11.2021.
 * java.karpenko@gmail.com
 */

class StringPreference(
    private val sharedPreferences: SharedPreferences,
    private val key: String? = null,
    private val defValue: String = ""
) : ReadWriteProperty<Any, String> {

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        sharedPreferences.edit { putString(key ?: property.name, value) }
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return sharedPreferences.getString(key ?: property.name, defValue) ?: defValue
    }
}