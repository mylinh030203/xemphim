package com.example.xemphim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.xemphim.model.phim
import kotlinx.android.synthetic.main.layout_item.view.*
import java.util.Objects
import java.util.zip.Inflater

class rvAdapter(val list: List<phim>, val rvInter: rvInterface)  : RecyclerView.Adapter<rvAdapter.phimHolder>(){
    inner class phimHolder(itemView : View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): phimHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent, false)
        return phimHolder(view)
    }

    override fun onBindViewHolder(holder: phimHolder, position: Int) {
        holder.itemView.apply {
            tvName.text = list[position].name
            img.setImageResource(list[position].img)

            holder.itemView.setOnClickListener {
                rvInter.Onclick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}