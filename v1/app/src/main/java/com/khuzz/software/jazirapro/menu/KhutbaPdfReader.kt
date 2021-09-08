package com.khuzz.software.jazirapro.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.github.barteksc.pdfviewer.PDFView
import com.khuzz.software.jazirapro.R

class KhutbaPdfReader : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_khutba_pdf_reader)

        val barViewer = findViewById<RelativeLayout>(R.id.bar_viewer)
        val khutbahPdfAr = findViewById<PDFView>(R.id.khutbah_viewer_ar)
        val khutbahPdfFr = findViewById<PDFView>(R.id.khutbah_viewer_fr)

        val translateToFrench = findViewById<ImageView>(R.id.go_to_french)
        val goToPrevious = findViewById<ImageView>(R.id.go_to_previous)



        translateToFrench.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (khutbahPdfAr.getVisibility() == View.VISIBLE) {
                    khutbahPdfAr.setVisibility(View.INVISIBLE)
                    khutbahPdfFr.setVisibility(View.VISIBLE)
                } else {
                    khutbahPdfAr.setVisibility(View.VISIBLE)
                    khutbahPdfFr.setVisibility(View.INVISIBLE)
                }

            }

        })

        val intent = intent
        val khutbaah = intent.getIntExtra("khutbaah", 0)

        if (khutbaah == 0) {
            khutbahPdfAr.fromAsset("khutbatul_ghulamiyyah_ar.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .fitEachPage(true)
                .autoSpacing(false)
                .pageSnap(true)
                .pageFling(true)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .load()

            khutbahPdfFr.fromAsset("khutbatul_ghulamiyyah_fr.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true)
                .fitEachPage(true)
                .autoSpacing(false)
                .pageSnap(true)
                .pageFling(true)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .load()
        }


    }

    fun goToPrevious(view: View?) {
        startActivity(Intent(applicationContext, MenuActivity::class.java))
        finish()
    }
}