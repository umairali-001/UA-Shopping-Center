package com.sprizen.uashoppingcenter.SellerFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sprizen.uashoppingcenter.Activities.AddProductActivity
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.FragmentProductsBinding


class ProductsFragment : Fragment() {

    lateinit var binding: FragmentProductsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProductsBinding.inflate(layoutInflater)

        binding.btnAddNewProduct.setOnClickListener {
            startActivity(Intent(requireContext(), AddProductActivity::class.java))
        }






        return binding.root
    }

}