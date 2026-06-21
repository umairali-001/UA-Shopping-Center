package com.sprizen.uashoppingcenter.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.R
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

    }

    override fun onBindViewHolder(p0: AdapterItem.ViewHolder, p1: Int) {

    }

    override fun getItemCount(): Int {
        return itemList.size
    }




    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){




    }
}