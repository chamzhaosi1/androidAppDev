package com.example.fragmentrecycleview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val itemList: ArrayList<DataModel>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.label_tv.setText(currentItem.labelTV)
        holder.label_img.setImageResource(R.drawable.ic_launcher_background)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val label_tv : TextView = itemView.findViewById(R.id.labelTV)
        val label_img : ImageView = itemView.findViewById((R.id.labelImg))
    }

}