package com.ishaan.navigationsample.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ishaan.navigationsample.R

class ActivityWithTransitionAnimation: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transition_activity)

        supportStartPostponedEnterTransition()
    }
}