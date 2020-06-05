package com.ishaan.navigationsample.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.ishaan.navigationsample.R
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.search_fragment.*

class SearchFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        open_activity_with_transition?.setOnClickListener {
            val textPair: Pair<View, String> = Pair.create(txt_msg, txt_msg.transitionName)
            val imgPair: Pair<View, String> = Pair.create(img_content, img_content.transitionName)

            val opts = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(),
                textPair, imgPair)
            val extras = ActivityNavigatorExtras(opts, 0)
            findNavController().navigate(R.id.transition_activity, null, null, extras)
        }
    }
}