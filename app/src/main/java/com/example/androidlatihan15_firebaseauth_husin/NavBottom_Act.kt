package com.example.androidlatihan15_firebaseauth_husin


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidlatihan15_firebaseauth_husin.AllFragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.navbotton_act.*
import android.view.Menu
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fr_person.*


class NavBottom_Act : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navbotton_act)




        setSupportActionBar(toolbar)

        toolbar.inflateMenu(R.menu.main_menu)

        val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
                var selectedFragment: Fragment? = null

                when (menuItem.itemId) {
                    R.id.nav_home -> selectedFragment =
                        HomeFragment()
                    R.id.nav_search -> selectedFragment =
                        SearchFragment()
                    R.id.nav_upload -> selectedFragment =
                        UploadFragment()
                    R.id.nav_favorite -> selectedFragment =
                        FavoriteFragment()
                    R.id.nav_person -> selectedFragment =
                        PersonFragment()
                }
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    selectedFragment!!
                ).commit()

                true
            }

        bottom_navigation.setOnNavigationItemSelectedListener(navListener)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            R.id.action_profile -> {
              startActivity(Intent(this,Profile::class.java))

            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu)
    }


}

