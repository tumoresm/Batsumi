package com.example.batsumi.Navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import com.example.batsumi.Login_AND_SignUp.UserInfo
import com.example.batsumi.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Profile : AppCompatActivity() {
    var img: ImageView? = null
    var name: TextView? = null
    var email: TextView? = null
    var firebaseAuth: FirebaseAuth? = null
    var firebaseDatabase: FirebaseDatabase? = null


    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        img = findViewById(R.id.imageView4)
        name = findViewById(R.id.pro_name)
        email = findViewById(R.id.pro_email)
        firebaseAuth = FirebaseAuth.getInstance()
        val user: FirebaseUser? = firebaseAuth!!.getCurrentUser()
        firebaseDatabase = FirebaseDatabase.getInstance()
        val databaseReference: DatabaseReference =
            firebaseDatabase!!.getReference("user2/" + firebaseAuth!!.getUid())
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(@NonNull snapshot: DataSnapshot) {
                val info: UserInfo? = snapshot.getValue(UserInfo::class.java)
                if (info != null) {
                    if (info.getMob() != null) {
                        name.setText(info.getMob())
                    }
                    if (info.getEmail() != null) {
                        email.setText(info.getEmail())
                    }
                    if (info.getImg() != null) {
                        img.setImageURI(info.getImg())
                    }
                }
            }


            override fun onCancelled(@NonNull error: DatabaseError) {
                Toast.makeText(this@Profile, error.getCode(), Toast.LENGTH_SHORT).show()
            }
        })
    }
}