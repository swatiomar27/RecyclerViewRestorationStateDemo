package com.swati.recyclerviewrestorationpolicydemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import com.swati.recyclerviewrestorationpolicydemo.R
import com.swati.recyclerviewrestorationpolicydemo.model.DataModel
import java.util.*

class DataAdapter(private var dataList: List<DataModel>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList[position]
        holder.titleTextView.text = dataModel.title
        if (dataModel.thumbnailUrl.isEmpty()) {
            Picasso.get().load(R.drawable.ic_android_logo).into(holder.ivUrl)
        } else {
            Picasso.get().load(dataModel.thumbnailUrl).into(holder.ivUrl)
        }
    }

    fun updateList(dataList: ArrayList<DataModel>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var titleTextView: TextView = itemLayoutView.findViewById(R.id.title)
        var ivUrl: ShapeableImageView = itemLayoutView.findViewById(R.id.iv_url)
    }

}
