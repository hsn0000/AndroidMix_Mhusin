package com.example.androidlatihan15_firebaseauth_husin

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fr_person.*
import kotlinx.android.synthetic.main.profile.*

class Profile : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        btn_logout_profile.setOnClickListener {
            val fAuth = FirebaseAuth.getInstance()
            fAuth.signOut()
          finish()
        }

    }


}
