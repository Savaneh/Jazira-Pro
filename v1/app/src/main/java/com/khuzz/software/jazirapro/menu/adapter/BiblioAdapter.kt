package com.khuzz.software.jazirapro.menu.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khuzz.software.jazirapro.R
import com.khuzz.software.jazirapro.menu.KhutbaPdfReader
import com.khuzz.software.jazirapro.menu.helper.BiblioHelper

class BiblioAdapter (

    private val bookList: List<BiblioHelper>)
    : RecyclerView.Adapter<BiblioAdapter.BiblioViewHolder>() {
    class BiblioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookImage: ImageView = itemView.findViewById(R.id.book_img)
        val bookName: TextView = itemView.findViewById(R.id.book_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BiblioViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.livre_biblio_model,
            parent, false
        )
        return BiblioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BiblioViewHolder, position: Int) {
        val currentItem = bookList[position]

        holder.bookImage.setImageResource(currentItem.bookImage)
        holder.bookName.setText(currentItem.bookName)

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, KhutbaPdfReader::class.java)
            intent.putExtra("menu_book", position)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount() = bookList.size
}