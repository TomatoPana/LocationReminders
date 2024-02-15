package com.example.locationreminders

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null

    private lateinit var email: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        email = findViewById(R.id.emailTextField)
        password = findViewById(R.id.passwordTextField)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)
        resultTextView = findViewById(R.id.resultTextView)
        loginButton.setOnClickListener {
            auth.signInWithEmailAndPassword(
                email.editText?.text.toString(),
                password.editText?.text.toString()
            ).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Success
                    updateUI()
                } else {
                    // Failure
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // User has login
            user = currentUser
            updateUI()
        }
    }

    private fun updateUI() {
        user?.let {
            // Name, email address, and profile photo Url
            val name = it.displayName
            val email = it.email
            val photoUrl = it.photoUrl

            // Check if user's email is verified
            val emailVerified = it.isEmailVerified

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            val uid = it.uid
            resultTextView.text = "Logged in as ${name} with email ${email} and photo url ${photoUrl} and uid ${uid}. The email is verified? ${emailVerified}"
            this.email.visibility = View.GONE
            this.password.visibility = View.GONE
            this.loginButton.visibility = View.GONE
            this.registerButton.visibility = View.GONE
            resultTextView.visibility = View.VISIBLE
        }
    }

}