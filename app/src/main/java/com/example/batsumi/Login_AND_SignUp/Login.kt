package com.example.batsumi.Login_AND_SignUp

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.example.batsumi.MainCourse.DashBoard
import com.example.batsumi.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider

class Login : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    var fb: FloatingActionButton? = null
    var google: FloatingActionButton? = null
    var twitter: FloatingActionButton? = null
    var googleSignInClient: GoogleSignInClient? = null
    var firebaseAuth: FirebaseAuth? = null
    var v = 0f
    @SuppressLint("WrongViewCast")

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth = FirebaseAuth.getInstance()
        val user: FirebaseUser = firebaseAuth.getCurrentUser()
        if (user != null) {
            finish()
            startActivity(Intent(this@Login, DashBoard::class.java))
        }

        //binding
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        fb = findViewById(R.id.floatingBut2_fb)
        google = findViewById(R.id.floatingBut1_google)
        twitter = findViewById(R.id.floatingBut3_twitter)

        // setting 2 tabs in tab layout
        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("Sign Up"))
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL)
        val loginAdapter = LoginAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount())
        viewPager.setAdapter(loginAdapter)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        fb.setTranslationY(300)
        google.setTranslationY(300)
        twitter.setTranslationY(300)
        tabLayout.setTranslationY(300)
        fb.setAlpha(v)
        google.setAlpha(v)
        twitter.setAlpha(v)
        tabLayout.setAlpha(v)
        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start()
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start()
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start()
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start()
        /** signing through google  */

        // initializing sign in options
        val googleSignInOptions: GoogleSignInOptions = Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken("222324874194-i72pftkedkdrbnlbopthp6lt20c5oqrt.apps.googleusercontent.com")
            .requestEmail()
            .build()

        //initialize sign in client
        googleSignInClient = GoogleSignIn.getClient(this@Login, googleSignInOptions)
        google.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                val intent: Intent = googleSignInClient.getSignInIntent()
                startActivityForResult(intent, 100)
            }
        })


        // signing through FB
        fb.setOnClickListener(object : View.OnClickListener() {
            override fun onClick(v: View?) {
            }
        })

        // signing through Twitter
        twitter.setOnClickListener(object : View.OnClickListener() {
            override fun onClick(v: View?) {
            }
        })
    }

    //google sign in activity
    @Override
    protected override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // check condition for request code
        if (requestCode == 100) {
            //initialize task
            val signInAccountTask: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            //check condition
            if (signInAccountTask.isSuccessful()) {
                //when sign is successful
                //initialize string
                Toast.makeText(this, "Google Sign In successful", Toast.LENGTH_SHORT).show()
                try {
                    val googleSignInAccount: GoogleSignInAccount = signInAccountTask.getResult(
                        ApiException::class.java
                    )
                    //check condition
                    if (googleSignInAccount != null) {
                        //when acc is not null
                        //initialize credential
                        val authCredential: AuthCredential =
                            GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null)
                        //check credintial
                        firebaseAuth.signInWithCredential(authCredential).addOnCompleteListener(
                            this,
                            object : OnCompleteListener<AuthResult?>() {
                                @Override
                                override fun onComplete(@NonNull task: Task<AuthResult?>) {
                                    //check condition
                                    if (task.isSuccessful()) {
                                        //when task is successful
                                        //Redirect to activity
                                        startActivity(
                                            Intent(
                                                this@Login,
                                                DashBoard::class.java
                                            ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        )
                                        Toast.makeText(
                                            this@Login,
                                            "Authentication done !!!!!!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        Toast.makeText(
                                            this@Login,
                                            "Authentication Failed !!!!!!!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            })
                    }
                } catch (e: ApiException) {
                    e.printStackTrace()
                }
            }
        }
    }
}