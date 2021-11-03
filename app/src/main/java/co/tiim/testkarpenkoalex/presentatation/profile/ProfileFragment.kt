package co.tiim.testkarpenkoalex.presentatation.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import co.tiim.testkarpenkoalex.R
import co.tiim.testkarpenkoalex.common.lifecycle.observe
import co.tiim.testkarpenkoalex.presentatation.base.BaseFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : BaseFragment() {

    private val viewModel: ProfileViewModel by viewModels()

    override val layoutRes = R.layout.fragment_profile

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btEdit.setOnClickListener { viewModel.onEditClick() }

        observe(viewModel.profileData) {
            it.run {
                inputUserName.setText(userName)
                txtTitle.text = userTitle
                txtCounterVideos.text = getString(R.string.video_count, userVideos)
                txtFollowingCount.text = userFollowing.toString()
                txtFansCount.text = userFans.toString()
                txtHeartsCount.text = userHearts.toString()
                showImage(userLocalImage)
            }
        }

        inputUserName.doAfterTextChanged {
            viewModel.onNameChanged(it.toString().trim())
        }

        observe(viewModel.saveState) {
            if (it) {
                Toast.makeText(requireContext(), R.string.save_completed, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), R.string.error_saving, Toast.LENGTH_SHORT).show()
            }
        }

        observe(viewModel.error) {
            Toast.makeText(requireContext(), R.string.error_loading, Toast.LENGTH_SHORT).show()
        }

        lifecycle.addObserver(viewModel)
    }

    private fun showImage(userLocalImage: String) =
        Glide.with(requireContext())
            .load(userLocalImage)
            .error(R.drawable.user_photo)
            .transform(CenterCrop(), CircleCrop())
            .into(avatarImage)


}