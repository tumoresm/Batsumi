package com.example.batsumi.Login_AND_SignUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.batsumi.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass.
 */
class SignUpFragment : Fragment() {
    var firebaseAuth: FirebaseAuth? = null
    var user_email: String? = null
    var user_pass: String? = null
    var con_pass: String? = null
    var mob: String? = null
    var signEmail: EditText? = null
    var signPass: EditText? = null
    var signCpass: EditText? = null
    var signMob: EditText? = null
    var signBtn: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        signBtn = view.findViewById(R.id.signup_btn)
        signCpass = view.findViewById(R.id.signup_confirm_password)
        signEmail = view.findViewById(R.id.signup_email)
        signMob = view.findViewById(R.id.signup_mobile_number)
        signPass = view.findViewById(R.id.signup_password)
        firebaseAuth = FirebaseAuth.getInstance()
        signBtn.setOnClickListener(View.OnClickListener {
            if (isValid) {
                user_email = signEmail.getText().toString().trim { it <= ' ' }
                user_pass = signPass.getText().toString().trim { it <= ' ' }
                con_pass = signCpass.getText().toString().trim { it <= ' ' }
                mob = signMob.getText().toString().trim { it <= ' ' }
                firebaseAuth.createUserWithEmailAndPassword(user_email, user_pass)
                    .addOnCompleteListener(object : OnCompleteListener<AuthResult?>() {
                        fun onComplete(task: jdk.internal.jline.internal.ShutdownHooks.Task<AuthResult?>) {
                            if (task.isSuccessful()) {
                                sendEmailVerification()
                                sendInfo()
                                //finish();
                                //getActivity().finish();
                                //startActivity(new Intent(getContext(), DashBoard.class));
                            } else {
                                Toast.makeText(
                                    context,
                                    "Something went wrong may be password is too weak ...",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
            }
        })
        return view
    }

    val isValid: Boolean
        get() {
            user_email = signEmail!!.text.toString().trim { it <= ' ' }
            user_pass = signPass!!.text.toString().trim { it <= ' ' }
            con_pass = signCpass!!.text.toString().trim { it <= ' ' }
            mob = signMob!!.text.toString().trim { it <= ' ' }
            if (user_email!!.isEmpty() && user_pass!!.isEmpty() && con_pass!!.isEmpty() && mob!!.isEmpty()) {
                Toast.makeText(context, "Something Went Wrong TRY AGAIN", Toast.LENGTH_SHORT).show()
                return false
            }
            if (user_pass != con_pass) {
                Toast.makeText(context, "Password did not match", Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }

    private fun sendEmailVerification() {
        val firebaseUser: FirebaseUser = firebaseAuth.getCurrentUser()
        if (firebaseUser != null) {
            firebaseUser.sendEmailVerification()
                .addOnCompleteListener(object : OnCompleteListener<Void?>() {
                    fun onComplete(task: jdk.internal.jline.internal.ShutdownHooks.Task<Void?>) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Verification mail is send", Toast.LENGTH_SHORT)
                                .show()
                            firebaseAuth.signOut()
                            //finish();
                            activity!!.finish()
                            //startActivity(new Intent(getContext(), DashBoard.class));
                        } else {
                            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                })
        }
    }

    private fun sendInfo() {
        val userInfo = UserInfo(user_email, user_pass, mob, null)
        val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
        //DatabaseReference myref = firebaseDatabase.getReference(firebaseAuth.getUid());
        val myref: DatabaseReference =
            firebaseDatabase.getReference("user2/" + firebaseAuth.getUid())
        myref.setValue(userInfo)
    }
}