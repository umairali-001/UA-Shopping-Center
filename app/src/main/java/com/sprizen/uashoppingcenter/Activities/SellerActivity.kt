package com.sprizen.uashoppingcenter.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.SellerFragments.DashboardFragment
import com.sprizen.uashoppingcenter.SellerFragments.EarningFragment
import com.sprizen.uashoppingcenter.SellerFragments.MoreFragment
import com.sprizen.uashoppingcenter.SellerFragments.OrderFragment
import com.sprizen.uashoppingcenter.SellerFragments.ProductsFragment
import com.sprizen.uashoppingcenter.databinding.ActivitySellerBinding

class SellerActivity : AppCompatActivity() {
    lateinit var binding: ActivitySellerBinding

    lateinit var fragmentList: MutableList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySellerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()


        initializeEveryThing()

    }




    fun initializeEveryThing(){

        setUpViewPager()


        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })















    }


    fun setUpViewPager(){

        fragmentList = ArrayList()

        var firstFragment  = DashboardFragment()
        var secondFragment =  ProductsFragment()
        var thirdFragment  = OrderFragment()
        var fourthFragment = EarningFragment()
        var fifthFragment = MoreFragment()
        fragmentList.add(firstFragment)
        fragmentList.add(secondFragment)
        fragmentList.add(thirdFragment)
        fragmentList.add(fourthFragment)
        fragmentList.add(fifthFragment)

        var fragmentAdapter = FragmentAdapter(supportFragmentManager,lifecycle,fragmentList)

        binding.viewPager.adapter=fragmentAdapter





    }

    class FragmentAdapter( fragmentManager: FragmentManager,lifecycle: Lifecycle,fragmentList :
    MutableList<Fragment>) : FragmentStateAdapter(fragmentManager,lifecycle){

        var fragmentList : MutableList<Fragment>

        init {
            this.fragmentList = fragmentList
        }



        override fun createFragment(position: Int): Fragment {
           return fragmentList[position]
        }

        override fun getItemCount(): Int {
            return fragmentList.size

        }



    }

}