package com.example.batsumi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class Profile : AppCompatActivity() {
    var img: ImageView? = null
    var name: TextView? = null
    var email: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Batsumi)
        setContentView(R.layout.activity_profile)
        img = findViewById(R.id.imageView4)
        name = findViewById(R.id.pro_name)
        email = findViewById(R.id.pro_email)




    }
}