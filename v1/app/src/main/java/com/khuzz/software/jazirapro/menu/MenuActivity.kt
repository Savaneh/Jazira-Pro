package com.khuzz.software.jazirapro.menu

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.khuzz.software.jazirapro.R
import com.khuzz.software.jazirapro.coran.CoranScreen
import com.khuzz.software.jazirapro.menu.adapter.BiblioAdapter
import com.khuzz.software.jazirapro.menu.helper.BiblioHelper

class MenuActivity : AppCompatActivity() {
    var daily_verset_img: ImageView? = null
    var daily_bayt_img: ImageView? = null
    var share_verset_btn: ConstraintLayout? = null
    var share_bayt_btn: ConstraintLayout? = null

    //Variables
    val END_SCALE = 0.7f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Création du recyclerView pour la biblioThèque
        val biblioRv = findViewById<RecyclerView>(R.id.biblio_rv)

        biblioRv.setHasFixedSize(true)
        biblioRv.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        val bookList = arrayListOf<BiblioHelper>()

        bookList.add(BiblioHelper(R.drawable.biblio_bcg,"En cours \\n de developpement"))
        bookList.add(BiblioHelper(R.drawable.biblio_bcg_un ,"En cours \\n de developpement"))
        bookList.add(BiblioHelper(R.drawable.biblio_bcg ,"En cours \\n de developpement"))
        bookList.add(BiblioHelper(R.drawable.biblio_bcg_un ,"En cours \\n de developpement"))
        bookList.add(BiblioHelper(R.drawable.biblio_bcg ,"En cours \\n de developpement"))

        biblioRv.adapter = BiblioAdapter(bookList)
        biblioRv.setAdapter(biblioRv.adapter)
        // Fin du recyclerView de la bibliothèque

        // Déclaration des bouttons des catégories
        val khutbahBtn = findViewById<CardView>(R.id.khutbah_btn)
        val coranBtn = findViewById<CardView>(R.id.coran_btn)
        val madhuBtn = findViewById<CardView>(R.id.madhu_btn)
        val fiqhBtn = findViewById<CardView>(R.id.fiqh_btn)
        val duaaBtn = findViewById<CardView>(R.id.duaa_btn)
        val wasiyaatBtn = findViewById<CardView>(R.id.wassiyaat_btn)
        val viewAllBtn = findViewById<ConstraintLayout>(R.id.view_all_btn)
        val viewAllBtnBayt = findViewById<ConstraintLayout>(R.id.view_all_btn_bayt)
        //val dailyBaytImg = findViewById<ImageView>(R.id.daily_bayt_img)
        share_verset_btn = findViewById(R.id.share_verset_btn)
        share_bayt_btn = findViewById(R.id.share_bayt_btn)
        daily_verset_img = findViewById(R.id.daily_verset_img)
        daily_bayt_img = findViewById(R.id.daily_bayt_img)

        // Ouverture de nouveaux écrans à partir des boutons
        khutbahBtn.setOnClickListener {
            val intent = Intent(this, KhutbaPdfReader::class.java)
            startActivity(intent)
            intent.putExtra("khutbaah", 0)
        }
        coranBtn.setOnClickListener {
            val intent = Intent(this, CoranScreen::class.java)
            startActivity(intent)
        }
        madhuBtn.setOnClickListener {
            val intent = Intent(this, CoranScreen::class.java)
            startActivity(intent)
        }
        fiqhBtn.setOnClickListener {
            val intent = Intent(this, CoranScreen::class.java)
            startActivity(intent)
        }
        duaaBtn.setOnClickListener {
            val intent = Intent(this, CoranScreen::class.java)
            startActivity(intent)
        }
        wasiyaatBtn.setOnClickListener {
            val intent = Intent(this, CoranScreen::class.java)
            startActivity(intent)
        }
        viewAllBtn.setOnClickListener {
            val intent = Intent(this, CoranScreen::class.java)
            startActivity(intent)
        }
        viewAllBtnBayt.setOnClickListener {
            val intent = Intent(this, CoranScreen::class.java)
            startActivity(intent)
        }

        // Déclaration des Navigations Drawer
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        val dashboardBtn = findViewById<ImageView>(R.id.menu_dashboard_btn)
        dashboardBtn.setOnClickListener(View.OnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        })
        navigationView.bringToFront()
        navigationView.setCheckedItem(R.id.nav_home)
        navigationView.setNavigationItemSelectedListener{
            when (it.itemId){
                R.id.nav_home -> {
                }
                R.id.nav_coran -> {
                    val intent = Intent(this, CoranScreen::class.java)
                    startActivity(intent)
                    finish ()
                }
                R.id.nav_madhu -> {
                    val intent = Intent(this, CoranScreen::class.java)
                    startActivity(intent)
                    finish ()
                }
                R.id.nav_duaa -> {
                    val intent = Intent(this, CoranScreen::class.java)
                    startActivity(intent)
                    finish ()
                }
                R.id.nav_fiqh -> {
                    val intent = Intent(this, CoranScreen::class.java)
                    startActivity(intent)
                    finish ()
                }
                R.id.nav_wassiyaath -> {
                    val intent = Intent(this, CoranScreen::class.java)
                    startActivity(intent)
                    finish ()
                }
            }
            true
        }



        share_verset_btn!!.setOnClickListener {
            val bitmapDrawable = daily_verset_img!!.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap
            val bitmapPath =
                MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Some Title", null)
            val bitmapUri = Uri.parse(bitmapPath)
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
            startActivity(Intent.createChooser(intent, "Partager"))
        }



        share_bayt_btn!!.setOnClickListener {
            val bitmapDrawable = daily_bayt_img!!.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap
            val bitmapPath =
                MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Some khuzz", null)
            val bitmapUri = Uri.parse(bitmapPath)
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM, bitmapUri)
            startActivity(Intent.createChooser(intent, "Partager"))
        }


    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

}