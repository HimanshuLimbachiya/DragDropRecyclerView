package com.example.win10.dragdroprecyclerview

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

class CustomAdapter(private val mContext : Context, private val imageList: ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<AppCompatImageView>(R.id.img_ImageView)!!
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomAdapter.MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: CustomAdapter.MyViewHolder, position: Int) {
        Glide.with(mContext).load(imageList[position]).into(holder.imageView)
    }
}