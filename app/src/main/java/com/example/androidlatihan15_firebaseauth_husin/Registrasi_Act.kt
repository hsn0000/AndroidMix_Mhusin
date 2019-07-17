package com.example.androidlatihan15_firebaseauth_husin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login_act.*
import kotlinx.android.synthetic.main.register_act.*
import kotlinx.android.synthetic.main.register_act.et_email
import kotlinx.android.synthetic.main.register_act.et_password

class Registrasi_Act : AppCompatActivity(){

    lateinit var fAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_act)
        fAuth = FirebaseAuth.getInstance()

        btn_regist.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            if (email.isNotEmpty() || password.isNotEmpty() ||
                    !email.equals("") || !password.equals("")){
                fAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener{
                        if (it.isSuccessful){
                            Toast.makeText(this,"REGISTRASI berhasil",
                                Toast.LENGTH_SHORT).show()
                            onBackPressed()
                        }else{
                            Toast.makeText(this,"REGISTRAI GAGAL",
                                Toast.LENGTH_SHORT).show()
                        }
                    }

            }else{
                Toast.makeText(this,"email atau password tidak boleh kosong",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}