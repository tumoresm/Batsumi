package com.example.batsumi.DRVinterface

import com.example.batsumi.ResDynamicModel
import java.util.*


interface UpdateResRV {
    fun callBack(position: Int, dy_items: ArrayList<ResDynamicModel>)
}