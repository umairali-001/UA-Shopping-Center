package com.sprizen.uashoppingcenter.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sprizen.uashoppingcenter.Activities.AddProductActivity
import com.sprizen.uashoppingcenter.Activities.SellerActivity
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding= FragmentProfileBinding.inflate(layoutInflater)

        binding.sellerBtn.setOnClickListener {
            startActivity(Intent(requireContext(), SellerActivity::class.java))
        }





        return binding.root
    }
}