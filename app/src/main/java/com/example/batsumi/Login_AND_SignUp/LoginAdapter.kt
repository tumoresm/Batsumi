package com.example.batsumi.Login_AND_SignUp


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class LoginAdapter : FragmentPagerAdapter {
    private var context: Context? = null

    @get:Override
    var count = 0

    constructor(fm: FragmentManager?, context: Context?, totalTabs: Int) : super(fm) {
        this.context = context
        count = totalTabs
    }

    constructor(fm: FragmentManager?) : super(fm) {}

    @Override
    fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> {
                LoginFragment()
            }
            1 -> {
                SignUpFragment()
            }
            else -> null
        }
    }
}