package com.khuzz.software.jazirapro.coran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.khuzz.software.jazirapro.R
import com.khuzz.software.jazirapro.coran.fragments.JuzzFragment
import com.khuzz.software.jazirapro.coran.fragments.SouratesFavoriFragment
import com.khuzz.software.jazirapro.coran.fragments.SouratesFragment
import com.khuzz.software.jazirapro.menu.MenuActivity

class CoranScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coran_screen)


        val chipNavigationBar = findViewById<ChipNavigationBar>(R.id.menu_nav_coran)
        chipNavigationBar.setItemSelected(R.id.sourates_nav_button,true)
        supportFragmentManager.beginTransaction()
            .replace(R.id.coran_fragment_container, SouratesFragment()).commit()

        chipNavigationBar.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(i: Int) {
                var fragment: Fragment? = null
                when (i) {
                    R.id.sourates_nav_button -> fragment = SouratesFragment()
                    R.id.juzz_nav_button -> fragment = JuzzFragment()
                    R.id.favorites_nav_button -> fragment = SouratesFavoriFragment()
                }
                supportFragmentManager.beginTransaction().replace(
                    R.id.coran_fragment_container,
                    fragment!!
                ).commit()
            }
        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MenuActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}