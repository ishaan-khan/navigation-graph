package com.ishaan.navigationsample.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.fragment.findNavController
import com.ishaan.navigationsample.R
import com.ishaan.navigationsample.view.toastMsg
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        simple_nav?.setOnClickListener {
            //this name is derived from the Fragment Name(i.e. MainFragment in this case)
            val action = MainFragmentDirections.actionMainFragmentToSimpleNavFragment()
            findNavController().navigate(action)
        }

        args_nav?.setOnClickListener {
            //capture arguments entered in the edit text
            val textMsg = nav_args?.text.toString()
            if(textMsg.isNotEmpty()) {
                val action = MainFragmentDirections
                    .actionMainFragmentToArgsNavFragment(textMsg)
                findNavController().navigate(action)
            }
            else {
                requireContext() toastMsg R.string.enter_args_msg
            }
        }

        animated_nav?.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAnimatedNavFragment()
            findNavController().navigate(action)
        }

        pop_up_nav?.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToPopupNavFragment()
            findNavController().navigate(action)
        }

        deep_link_nav?.setOnClickListener {
            val pendingIntent = NavDeepLinkBuilder(requireContext())
                .setGraph(R.navigation.main_navigation)
                .setDestination(R.id.popup_nav_fragment2)
                .createPendingIntent()
            pendingIntent.send()
        }
    }
}