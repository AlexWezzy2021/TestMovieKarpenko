package co.tiim.testkarpenkoalex.domain.usecases.profile

import co.tiim.testkarpenkoalex.data.entity.Profile
import co.tiim.testkarpenkoalex.domain.base.BaseUseCase
import co.tiim.testkarpenkoalex.domain.repository.ProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
class ProfileInteractor@Inject constructor(
    dispatcher: CoroutineDispatcher,
    private val profileRepository: ProfileRepository,
) : BaseUseCase(dispatcher) {

    suspend fun fetchProfile() = wrapResult {
        profileRepository.getProfile()
    }

    suspend fun saveProfile(profile: Profile) = wrapResult {
        profileRepository.editProfile(profile)
    }
}