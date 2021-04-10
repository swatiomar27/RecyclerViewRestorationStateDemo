package com.swati.recyclerviewrestorationpolicydemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.swati.recyclerviewrestorationpolicydemo.R

class RestoreDemoAdapter(private var dataList: ArrayList<String>) :
    RecyclerView.Adapter<RestoreDemoAdapter.DemoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
        return DemoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class DemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
            val ivUrl = itemView.findViewById<ShapeableImageView>(R.id.iv_url)
            tvTitle.text = dataList[position]
            Picasso.get().load(R.drawable.ic_android_logo).into(ivUrl)
        }
    }
}