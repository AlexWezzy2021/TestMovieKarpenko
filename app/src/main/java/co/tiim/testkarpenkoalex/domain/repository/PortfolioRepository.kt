package co.tiim.testkarpenkoalex.domain.repository

import co.tiim.testkarpenkoalex.data.entity.Profile
import co.tiim.testkarpenkoalex.data.store.ProfileLocalStore
import javax.inject.Inject

/**
 * Created by Alexander Karpenko on 02.11.2021.
 * java.karpenko@gmail.com
 */
class ProfileRepository @Inject constructor(
    private val portfolioLocalStore: ProfileLocalStore,
) {

    fun getProfile(): Profile =
        requireNotNull(portfolioLocalStore.getProfile())

    fun editProfile(profile: Profile) {
        return portfolioLocalStore.saveProfile(profile)
    }
}
