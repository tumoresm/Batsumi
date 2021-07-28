package com.example.batsumi.Login_AND_SignUp


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.batsumi.MainCourse.DashBoard
/*import com.example.batsumi.Navigation.Profile*/
import com.example.batsumi.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    var L_email: EditText? = null
    var L_pass: EditText? = null
    var L_btn: Button? = null
    var forgot_pass: TextView? = null
    var v = 0f
    var firebaseAuth: FirebaseAuth? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login, container, false)
        L_email = view.findViewById(R.id.login_email)
        L_pass = view.findViewById(R.id.login_password)
        L_btn = view.findViewById(R.id.login_btn)
        forgot_pass = view.findViewById(R.id.forgot)
        L_email.setTranslationY(800)
        L_pass.setTranslationY(800)
        L_btn.setTranslationY(800)
        forgot_pass.setTranslationY(800)
        L_email.setAlpha(v)
        L_pass.setAlpha(v)
        L_btn.setAlpha(v)
        forgot_pass.setAlpha(v)
        L_email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start()
        L_pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start()
        L_btn.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start()
        forgot_pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start()
        firebaseAuth = FirebaseAuth.getInstance()
        val user: FirebaseUser = firebaseAuth.getCurrentUser()
        if (user != null) {
            getActivity().finish()
            startActivity(Intent(getContext(), DashBoard::class.java))
        }

        //login
        L_btn.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                val user_email: String = L_email.getText().toString().trim()
                val user_pass: String = L_pass.getText().toString().trim()
                if (user_email.isEmpty() || user_pass.isEmpty()) {
                    Toast.makeText(getContext(), "Not entered anything ", Toast.LENGTH_SHORT).show()
                } else {
                    isValid(user_email, user_pass)
                }
                //startActivity(new Intent(getContext(), DashBoard.class));
            }
        })

        ///forgot password
        forgot_pass.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                startActivity(Intent(getActivity(), ForgotPassword::class.java))
            }
        })
        return view
    }

    //sign in function
    private fun isValid(user_email: String, user_pass: String) {
        firebaseAuth.signInWithEmailAndPassword(user_email, user_pass)
            .addOnCompleteListener(object : OnCompleteListener<AuthResult?>() {
                @Override
                fun onComplete(@NonNull task: Task<AuthResult?>) {
                    if (task.isSuccessful()) {
//                    Intent intent1 = new Intent(getContext(), DashBoard.class);
//                    Intent intent2 = new Intent(getContext(), Profile.class);
//                    intent1.putExtra("Email", user_email);
//                    intent1.putExtra("mob",u)
                        checkemailVerification()
                    } else {
                        Toast.makeText(getContext(), "Failed to Login", Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

    // check for verification
    private fun checkemailVerification() {
        val firebaseUser: FirebaseUser = FirebaseAuth.getInstance().getCurrentUser()
        val emailflag: Boolean = firebaseUser.isEmailVerified()
        if (emailflag) {
            //finish();
            getActivity().finish()
            Toast.makeText(getContext(), "Successfully Logged In", Toast.LENGTH_SHORT).show()
            startActivity(Intent(getContext(), DashBoard::class.java))
        } else {
            Toast.makeText(getContext(), "Verify your Email", Toast.LENGTH_SHORT).show()
            firebaseAuth.signOut()
        }
    }
}
