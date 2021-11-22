package co.tiim.testkarpenkoalex.domain.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Alexander Karpenko on 20.11.2021.
 * java.karpenko@gmail.com
 */
open class BaseViewModel : ViewModel() {
    val error = MutableLiveData<Error>()
}
