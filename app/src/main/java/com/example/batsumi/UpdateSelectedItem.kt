package com.example.batsumi


import android.content.Context
import java.util.*


interface UpdateSelectedItem {
    fun addItems(name: String?, price: String?)
    var myContext: Context?
    val items: ArrayList<Any?>?
}
