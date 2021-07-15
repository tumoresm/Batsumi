package com.example.batsumi.DRVinterface

import com.example.batsumi.DynamicRvModel
import java.util.*


interface UpdateRV {
    fun callBack(position: Int, dy_items: ArrayList<DynamicRvModel>)
}
