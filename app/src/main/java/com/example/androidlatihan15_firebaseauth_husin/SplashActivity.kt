package com.example.androidlatihan15_firebaseauth_husin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
//import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long=4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({

            startActivity(Intent(this,Login_Act::class.java))

            finish()
        }, SPLASH_TIME_OUT)
    }
}
