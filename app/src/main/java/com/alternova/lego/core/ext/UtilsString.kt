package com.alternova.lego.core.ext

import android.text.SpannableString
import android.text.style.ClickableSpan
import android.view.View


fun String.convertToSpannableStringWithClick( action : () -> Unit ) : SpannableString{
    //CREATE SPANNABLE STRING
    return SpannableString( this ).also {
        //CREATE LISTENER TO SPAN
        val listenerSpan: ClickableSpan = object : ClickableSpan(){
            override fun onClick(widget: View) { action() }
        }
        //MATCH LISTENER
        it.setSpan(listenerSpan, 0, this.length, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}