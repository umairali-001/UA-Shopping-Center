package com.sprizen.uashoppingcenter.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sprizen.uashoppingcenter.DATA_CLASS.ITEM

class AdapterItem(context: Context , itemList: MutableList<ITEM>): RecyclerView.Adapter<AdapterItem
    .ViewHolder>(){

        var context : Context
        var itemList : MutableList<ITEM>

        init {
            this.context=context
            this.itemList =itemList

        }


    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int,
    ): AdapterItem.ViewHolder {
        var view = LayoutInflater.from(context).inflate(com.sprizen.uashoppingcenter.R.layout
            .item_adapter,p0,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(binding: AdapterItem.ViewHolder, position: Int) {
        var pos = binding.bindingAdapterPosition
        val imagesList = listOf(
            com.sprizen.uashoppingcenter.R.drawable.image_1,
            com.sprizen.uashoppingcenter.R.drawable.images_2,
            com.sprizen.uashoppingcenter.R.drawable.images_3,
            com.sprizen.uashoppingcenter.R.drawable.image_5,
            com.sprizen.uashoppingcenter.R.drawable.images_7,
            com.sprizen.uashoppingcenter.R.drawable.images_8,
            com.sprizen.uashoppingcenter.R.drawable.image_1,
            com.sprizen.uashoppingcenter.R.drawable.images_2,
            com.sprizen.uashoppingcenter.R.drawable.images_3,
            com.sprizen.uashoppingcenter.R.drawable.image_5,
            com.sprizen.uashoppingcenter.R.drawable.images_7,
            com.sprizen.uashoppingcenter.R.drawable.images_8,
            com.sprizen.uashoppingcenter.R.drawable.image_1,
            com.sprizen.uashoppingcenter.R.drawable.images_2,
            com.sprizen.uashoppingcenter.R.drawable.images_3,
            com.sprizen.uashoppingcenter.R.drawable.image_5,
            com.sprizen.uashoppingcenter.R.drawable.images_7,
            com.sprizen.uashoppingcenter.R.drawable.images_8,
            com.sprizen.uashoppingcenter.R.drawable.image_1,
            com.sprizen.uashoppingcenter.R.drawable.images_2,
            com.sprizen.uashoppingcenter.R.drawable.images_3,
            com.sprizen.uashoppingcenter.R.drawable.image_5,
            com.sprizen.uashoppingcenter.R.drawable.images_7,
            com.sprizen.uashoppingcenter.R.drawable.images_8
        )

        binding.imageUrl.setImageResource(imagesList[pos])
        binding.itemName.setText(itemList[pos].itemName)
        binding.itemPrice.setText(itemList[pos].itemPrice)
        binding.itemRatting.setText(itemList[pos].itemRatings)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }




    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var imageUrl= itemView.findViewById<ImageView>(com.sprizen.uashoppingcenter.R.id.item_image_adapter)
        var itemName =itemView.findViewById<TextView>(com.sprizen.uashoppingcenter.R.id.item_name_adapter)
        var itemPrice =itemView.findViewById<TextView>(com.sprizen.uashoppingcenter.R.id.item_price_adapter)
        var itemRatting =itemView.findViewById<TextView>(com.sprizen.uashoppingcenter.R.id.item_ratting_adapter)




    }
}