package co.tiim.testkarpenkoalex.presentatation.profile

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.tiim.testkarpenkoalex.data.entity.Profile
import co.tiim.testkarpenkoalex.domain.usecases.profile.ProfileInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileInteractor: ProfileInteractor
) : ViewModel(), LifecycleObserver {

    private var profile: Profile? = null

    val saveState = MutableLiveData<Boolean>()
    val profileData = MutableLiveData<Profile>()
    val error = MutableLiveData<Error>()

    fun onEditClick() {
        profile?.let {
            viewModelScope.launch {
                profileInteractor.saveProfile(it).fold(
                    onSuccess = {
                        saveState.value = true
                    },
                    onFailure = {
                        saveState.value = false
                    }
                )
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getProfile() {
        if (profile != null) {
            profileData.value = profile
        } else {
            loadProfile()
        }
    }

    private fun loadProfile() {
        viewModelScope.launch {
            profileInteractor.fetchProfile().fold(
                onSuccess = {
                    profileData.value = it
                    profile = it
                },
                onFailure = {
                    error.value = it
                }
            )
        }
    }

    fun onNameChanged(userName: String) {
        this.profile = profile?.copy(userName = userName)
    }
}
