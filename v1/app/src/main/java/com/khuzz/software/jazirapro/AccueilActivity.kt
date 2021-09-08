package com.khuzz.software.jazirapro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.khuzz.software.jazirapro.menu.MenuActivity

class AccueilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil)
    }

    fun callMenuScreenFromAcceuil(view: View?) {
        startActivity(Intent(applicationContext, MenuActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        startActivity(Intent(applicationContext, MenuActivity::class.java))
        finish()
    }
}