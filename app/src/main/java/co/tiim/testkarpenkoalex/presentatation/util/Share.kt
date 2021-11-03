package co.tiim.testkarpenkoalex.presentatation.util

import android.app.Activity
import androidx.core.app.ShareCompat
import co.tiim.testkarpenkoalex.R


fun share(activity: Activity, shareLink: String): String {
    ShareCompat.IntentBuilder
        .from(activity)
        .setType("text/plain")
        .setChooserTitle(activity.getString(R.string.share_url))
        .setText(shareLink)
        .startChooser()
    return shareLink
}
