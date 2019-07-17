package com.example.androidlatihan15_firebaseauth_husin.AllFragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidlatihan15_firebaseauth_husin.Login_Act
import com.example.androidlatihan15_firebaseauth_husin.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fr_person.*
import java.util.zip.Inflater

class PersonFragment : Fragment() {
//    lateinit var fAuth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_person, container, false)


    }

}