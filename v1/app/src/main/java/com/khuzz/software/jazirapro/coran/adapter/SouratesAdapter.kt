package com.khuzz.software.jazirapro.coran.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khuzz.software.jazirapro.R
import com.khuzz.software.jazirapro.coran.SouratesHelper
import com.khuzz.software.jazirapro.coran.SouratesViewer

class SouratesAdapter (private val souratesList: List<SouratesHelper>): RecyclerView.Adapter<SouratesAdapter.SouratesViewHolder>(){

    class SouratesViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val sourateName: TextView = itemView.findViewById(R.id.sourates_recycler_name)
        val sourateRegion: TextView = itemView.findViewById(R.id.sourates_recycler_text_plus)
        val sourateImage: ImageView = itemView.findViewById(R.id.sourates_recycler_images)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SouratesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sourates_recycler_model,
            parent,false)
        return SouratesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SouratesViewHolder, position: Int) {
        val currentItem = souratesList[position]

        holder.sourateName.text = currentItem.name
        holder.sourateRegion.text = currentItem.region
        holder.sourateImage.setImageResource(currentItem.image)

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, SouratesViewer::class.java)
            intent.putExtra("sourate_position", position)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount()= souratesList.size
}