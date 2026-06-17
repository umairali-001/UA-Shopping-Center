package com.sprizen.uashoppingcenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class SliderAdapter(private val images: List<Int>) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgShoe: ImageView = view.findViewById(R.id.imgShoe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slider_item, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        // Modulo (%) use karne se image loop hoti rahegi
        holder.imgShoe.setImageResource(images[position % images.size])
    }

    // Infinite loop ke liye bada number return karte hain
    override fun getItemCount(): Int = Integer.MAX_VALUE
}