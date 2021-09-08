package com.khuzz.software.jazirapro.coran.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.khuzz.software.jazirapro.R
import com.khuzz.software.jazirapro.coran.JuzzViewer
import com.khuzz.software.jazirapro.coran.SouratesHelper

class JuzzAdapter (private val juzzList: List<SouratesHelper>): RecyclerView.Adapter<JuzzAdapter.JuzzViewHolder>(){
    class JuzzViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        val juzzNmae: TextView = itemView.findViewById(R.id.sourates_recycler_name)
        val juzzVersets: TextView = itemView.findViewById(R.id.sourates_recycler_text_plus)
        val juzzImage: ImageView = itemView.findViewById(R.id.sourates_recycler_images)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuzzViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.sourates_recycler_model,
            parent,false)
        return JuzzViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JuzzViewHolder, position: Int) {
        val currentItem = juzzList[position]

        holder.juzzNmae.text = currentItem.name
        holder.juzzVersets.text = currentItem.region
        holder.juzzImage.setImageResource(currentItem.image)

        holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, JuzzViewer::class.java)
            intent.putExtra("juzz_position", position)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount() = juzzList.size

}