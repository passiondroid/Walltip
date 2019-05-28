package com.walltip.core.util

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AlertDialog

/**
 * Created by Arif Khan on 2019-05-19.
 */

fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun Activity.showAlertDialog(message: String){
    AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton("Ok")
        { dialog, _ -> dialog?.dismiss() }
        .show()
}
