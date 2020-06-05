package com.ishaan.navigationsample.view

import android.content.Context
import android.widget.Toast

infix fun Context?.toastMsg(msg: String) {
    if(this != null)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

infix fun Context?.toastMsg(msg: Int) {
    if(this != null)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

class Utility {

    companion object {
        const val DEEP_LINK_NOTIFICATION_ID = 101
    }

}