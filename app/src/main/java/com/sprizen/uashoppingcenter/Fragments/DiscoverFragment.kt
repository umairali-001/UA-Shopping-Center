package com.sprizen.uashoppingcenter.Fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sprizen.uashoppingcenter.Adapters.AdapterItem
import com.sprizen.uashoppingcenter.DATA_CLASS.ITEM
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.FragmentDiscoverBinding
import com.sprizen.uashoppingcenter.databinding.FragmentHomeBinding


class DiscoverFragment : Fragment() {

    lateinit var binding: FragmentDiscoverBinding
    lateinit var adapterItem: AdapterItem

    lateinit var listOfItem: MutableList<ITEM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentDiscoverBinding.inflate(layoutInflater)
        listOfItem = mutableListOf<ITEM>()
        adapterItem = AdapterItem(this@DiscoverFragment as Activity,listOfItem)

//        listOfItem.addAll([0].itemUrl = R.drawable.image_1.toString()
//        listOfItem[0].itemName = "Testing Item this is my testing item i im a programmer"
//        listOfItem[0].itemPrice = "12,4445"
//        listOfItem[0].itemRatings = "4.5")

        var singleItem = ITEM(R.drawable.image_1.toString(),"Testing Item this is my testing item" +
                " i im a programmer","12,4445","4.5")
        listOfItem.add(singleItem)
        listOfItem.add(singleItem)
        listOfItem.add(singleItem)
        listOfItem.add(singleItem)













        initializeEveryThing()




        return binding.root
    }

    fun initializeEveryThing(){
        Toast.makeText(this@DiscoverFragment as Activity, "${listOfItem.size}", Toast.LENGTH_SHORT)
            .show()
    }

}