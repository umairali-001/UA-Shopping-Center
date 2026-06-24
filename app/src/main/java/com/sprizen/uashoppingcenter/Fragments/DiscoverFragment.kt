package com.sprizen.uashoppingcenter.Fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sprizen.uashoppingcenter.Adapters.AdapterItem
import com.sprizen.uashoppingcenter.DATA_CLASS.ITEM
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.FragmentDiscoverBinding
import com.sprizen.uashoppingcenter.databinding.FragmentHomeBinding


class DiscoverFragment : Fragment() {

    private lateinit var binding: FragmentDiscoverBinding
    private lateinit var adapterItem: AdapterItem
    private lateinit var listOfItem: MutableList<ITEM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentDiscoverBinding.inflate(inflater, container, false)

        listOfItem = mutableListOf()
        adapterItem = AdapterItem(requireContext(), listOfItem)



        val singleItem = ITEM(
            "R.drawable.image_1",
            "Testing Item this is my testing item i im a programmer",
            "12,4445",
            "4.5"
        )

        repeat(20) { listOfItem.add(singleItem) }
        adapterItem.notifyDataSetChanged()

        initializeEveryThing()

        return binding.root
    }

    private fun initializeEveryThing() {
        Toast.makeText(requireContext(), "${listOfItem.size}", Toast.LENGTH_SHORT).show()


    }
}
