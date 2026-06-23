package com.sprizen.uashoppingcenter.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCartBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
}