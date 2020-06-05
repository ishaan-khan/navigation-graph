package com.ishaan.navigationsample.view.fragments

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ishaan.navigationsample.R
import com.ishaan.navigationsample.view.Utility
import com.ishaan.navigationsample.view.toastMsg
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment: Fragment() {

    private val channelId = "channel_0"

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
            val pendingIntent = Navigation.findNavController(it)
                .createDeepLink()
                .setGraph(R.navigation.main_navigation)
                .setDestination(R.id.transition_activity)
                .createTaskStackBuilder()
                .getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT)

            val notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId, "Deep Links", NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(channel)
            }

            val builder = NotificationCompat.Builder(requireContext(), channelId)
                .setContentTitle("Navigation")
                .setContentText("Click me to see Deep Link in action")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_SOUND)
                .setAutoCancel(true)
            notificationManager.notify(Utility.DEEP_LINK_NOTIFICATION_ID, builder.build())
        }

        activity_nav?.setOnClickListener {
            val action = MainFragmentDirections.actionMainActivityToSecondaryActivity(withPopup = false)
            findNavController().navigate(action)
        }
    }
}