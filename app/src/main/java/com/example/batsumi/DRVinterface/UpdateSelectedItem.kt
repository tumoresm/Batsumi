package com.example.batsumi.DRVinterface

import java.util.*

interface UpdateSelectedItem {
    fun addItems(name: String?, price: String?)
    val items: ArrayList<Any?>?
}