package com.partners.texsun.app.utils.extensions

import android.view.View
import android.widget.Button

fun Button.hideButton(visibility: Int = View.INVISIBLE){
    this.isClickable = false
    this.visibility = visibility
}