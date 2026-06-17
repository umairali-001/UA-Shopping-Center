package com.sprizen.uashoppingcenter.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.adsFragment.FirstAdsFragment
import com.sprizen.uashoppingcenter.adsFragment.FourAdsFragment
import com.sprizen.uashoppingcenter.adsFragment.TherdAdsFragment
import com.sprizen.uashoppingcenter.adsFragment.secondAdsFragment
import com.sprizen.uashoppingcenter.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    lateinit var adsfragmentList: MutableList<Fragment>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)


            adsfragmentList=ArrayList()

            var firstFragment= FirstAdsFragment()
            var secondFragmint= secondAdsFragment()
            var threadFragment= TherdAdsFragment()
            var fourFragment= FourAdsFragment()


            adsfragmentList.add(firstFragment)
            adsfragmentList.add(secondFragmint)
            adsfragmentList.add(threadFragment)
            adsfragmentList.add(fourFragment)


            var fragmentAdapter =Fragmentadapter(parentFragmentManager,lifecycle,adsfragmentList)
            binding.adsviewpager.adapter=fragmentAdapter

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    class Fragmentadapter(fragmentManager: FragmentManager,lifecycle: Lifecycle,fragmentList: MutableList<Fragment>):FragmentStateAdapter(fragmentManager,lifecycle) {
        var fragmentList: MutableList<Fragment>

        init {
            this.fragmentList = fragmentList
        }

        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }
    }

}