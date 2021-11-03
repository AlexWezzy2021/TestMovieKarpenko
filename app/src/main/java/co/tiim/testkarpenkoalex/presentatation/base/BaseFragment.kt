package co.tiim.testkarpenkoalex.presentatation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    protected abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? =
        inflater.inflate(layoutRes, group, false)
}