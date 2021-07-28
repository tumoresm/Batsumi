package com.example.batsumi.Login_AND_SignUp


import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.batsumi.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    var forgot_email: EditText? = null
    var back: TextView? = null
    var submit: Button? = null
    var email: String? = null
    var firebaseAuth: FirebaseAuth? = null
    @Override
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        forgot_email = findViewById(R.id.forgot_email)
        back = findViewById(R.id.back_to_login)
        submit = findViewById(R.id.forgot_btn)
        firebaseAuth = FirebaseAuth.getInstance()
        back.setOnClickListener(object : View.OnClickListener() {
            @Override
            fun onClick(v: View?) {
                startActivity(Intent(this@ForgotPassword, Login::class.java))
                finish()
            }
        })
        submit.setOnClickListener(object : View.OnClickListener() {
            @Override
            fun onClick(v: View?) {
                email = forgot_email.getText().toString().trim()
                if (email.isEmpty()) {
                    Toast.makeText(this@ForgotPassword, "Enter Email", Toast.LENGTH_SHORT).show()
                } else {
                    firebaseAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(object : OnCompleteListener<Void?>() {
                            @Override
                            fun onComplete(@NonNull task: Task<Void?>) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(
                                        this@ForgotPassword,
                                        "Reset Password mail is send",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    finish()
                                    startActivity(Intent(this@ForgotPassword, Login::class.java))
                                } else {
                                    Toast.makeText(
                                        this@ForgotPassword,
                                        "Enter correct email or else go with Mobile number",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        })
                }
            }
        })
    }
}
