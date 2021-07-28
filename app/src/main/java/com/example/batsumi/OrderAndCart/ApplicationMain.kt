package com.example.batsumi.OrderAndCart

import android.app.Application
import android.content.Context
import java.util.ArrayList

class ApplicationMain : Application(), UpdateSelectedItem {
    var orderListModels: ArrayList<OrderListModel>? = null
    @Override
    fun onCreate() {
        super.onCreate()
        context = getApplicationContext()
        orderListModels = ArrayList()
    }

    @Override
    fun addItems(name: String, price: String) {
        orderListModels.add(OrderListModel(name, price))
    }

    @get:Override
    override val items: ArrayList<OrderListModel>?
        get() = orderListModels

    companion object {
        private var context: Context? = null
        val myContext: Context?
            get() = context
    }
}