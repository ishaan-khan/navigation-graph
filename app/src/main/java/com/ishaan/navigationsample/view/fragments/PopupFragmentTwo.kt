package com.ishaan.navigationsample.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ishaan.navigationsample.R
import kotlinx.android.synthetic.main.popup_fragment_two.*

class PopupFragmentTwo: Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.popup_fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        popup_fragment?.setOnClickListener {
            val action = PopupFragmentTwoDirections.actionPopupNavFragment2ToMainFragment()
            findNavController().navigate(action)
        }
    }
}