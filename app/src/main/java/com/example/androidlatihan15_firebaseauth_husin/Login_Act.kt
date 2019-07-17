package com.example.androidlatihan15_firebaseauth_husin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.login_act.*

class Login_Act : AppCompatActivity() {

    //untuk Request code
    private val RC_SIGN_IN = 7
    // untuk sign client
    private lateinit var mGoogleSignIn: GoogleSignInClient
    //umtuk firebase autenthication
    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_act)
        // inisialisasi
        fAuth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        )
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignIn = GoogleSignIn.getClient(this, gso)
        sign_in_button.setOnClickListener {
            signIN()
        }

        btn_regis.setOnClickListener {
            startActivity(Intent(this, Registrasi_Act::class.java))
        }

        btn_login.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()

            if (email.isNotEmpty() || password.isNotEmpty() ||
                    !email.equals("") || !password.equals("")){
                fAuth.signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener {
                        startActivity(Intent(this,NavBottom_Act::class.java))
                    }
                    .addOnFailureListener{
                        Toast.makeText(this,"LOGIN GAGAL",
                            Toast.LENGTH_SHORT).show()
                    }

            }else{
                Toast.makeText(this,"LOGIN GAGAL",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun signIN() {
        val signInIntent = mGoogleSignIn.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        d("FAUTH_LOGIN", "firebasaAuth : ${account.id}")

        val credential = GoogleAuthProvider.getCredential(account.idToken, null)

        fAuth.signInWithCredential(credential).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val user = fAuth.currentUser
                updateUI(user)

                //              Toast.makeText(
                //                 this,
                //                 "Login Berhasil Welcome ${fAuth.currentUser}",
                //                  Toast.LENGTH_SHORT
                //             ).show()

            } else {
                Toast.makeText(
                    this,
                    "LOGIN GAGAL", Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            Toast.makeText(
                this,
                "Login Berhasil Welcome ${user.displayName}",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this,NavBottom_Act::class.java))

        }
    }

    override fun onStart() {
        super.onStart()
        val user = fAuth.currentUser
        if (user != null) {
            updateUI(user)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                Log.e("AUTH_LOGIN", " LOGIN GAGAL")
            }
        }
    }
}



 //       if (fAuth.currentUser != null) {
  //          Toast.makeText(
  //              this, "Welcome ${fAuth.currentUser!!.displayName}",
  //              Toast.LENGTH_SHORT
 //          ).show()


