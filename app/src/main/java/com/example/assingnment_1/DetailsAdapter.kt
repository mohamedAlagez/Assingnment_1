package com.example.assingnment_1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items.view.*


class DetailsAdapter(var activity: Activity, var data: MutableList<Model>)
    : RecyclerView.Adapter<DetailsAdapter.myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return myViewHolder(root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        holder.tvName.text = data[position].name.toString()
        holder.tvAddress.text = data[position].address.toString()
        holder.tvPhone.text = data[position].phone.toString()

    }

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.tvName
        val tvAddress = itemView.tvAddress
        val tvPhone = itemView.tvPhone
    }

}