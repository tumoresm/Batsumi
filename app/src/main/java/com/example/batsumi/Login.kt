package com.example.batsumi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout


class Login : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var fb: FloatingActionButton? = null
    var google: FloatingActionButton? = null
    var twitter: FloatingActionButton? = null
    var v = 0f


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Batsumi)
        this.setContentView(R.layout.activity_login)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener() {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}

