package com.ishaan.navigationsample.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ishaan.navigationsample.R
import kotlinx.android.synthetic.main.navigated_fragment.*
import java.lang.Exception

class NavigatedFragment: Fragment() {

    private val args: NavigatedFragmentArgs? by navArgs()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.navigated_fragment, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataString = requireActivity().intent.dataString
        val data = try {
            if(args?.data.isNullOrEmpty()) dataString else args?.data
        }
        catch (e: Exception) {
            dataString
        }

        if(!data.isNullOrEmpty())
            nav_msg?.text = "Message received: $data"
    }
}