package com.sprizen.uashoppingcenter.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding= FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }
}