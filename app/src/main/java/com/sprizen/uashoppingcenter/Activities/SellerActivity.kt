package com.sprizen.uashoppingcenter.Activities

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
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
    lateinit var imageList : MutableList<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySellerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()


        initializeEveryThing()

    }




    fun initializeEveryThing(){



        setUpViewPager()

        imageList = ArrayList()

        var home = binding.dashboardBT
        var explore = binding.productsBT
        var fav = binding.ordersBT
        var profile = binding.earningsBT
        var more = binding.moreBT

        imageList.add(home)
        imageList.add(explore)
        imageList.add(fav)
        imageList.add(profile)
        imageList.add(more)



        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                TabLayout.INDICATOR_ANIMATION_MODE_ELASTIC
                binding.viewPager.currentItem = tab.position
                tabLayoutManager(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tabLayoutManager(tab.position)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                tabLayoutManager(tab.position)
            }

        })
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.getTabAt(position)?.select()
            }
        })














    }


    fun tabLayoutManager(position: Int?){
        when(position){
            0 ->{
                imageList[0].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_dashboard_filled
                    )
                )
                imageList[1].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_products
                    )
                )
                imageList[2].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_orders
                    )
                )
                imageList[3].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_earning
                    )
                )
                imageList[4].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_profile_white
                    )
                )

            }
            1-> {
                imageList[0].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_dashboard
                    )
                )
                imageList[1].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_produts_filled
                    )
                )
                imageList[2].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_orders
                    )
                )
                imageList[3].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_earning
                    )
                )
                imageList[4].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_profile_white
                    )
                )
            }
            2->{
                imageList[0].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_dashboard
                    )
                )
                imageList[1].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_products
                    )
                )
                imageList[2].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_orders_filled
                    )
                )
                imageList[3].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_earning
                    )
                )
                imageList[4].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_profile_white
                    )
                )
            }
            3->{
                imageList[0].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_dashboard
                    )
                )
                imageList[1].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_products
                    )
                )
                imageList[2].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_orders
                    )
                )
                imageList[3].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_earning_filled
                    )
                )
                imageList[4].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_profile_white
                    )
                )
            }
            4->{
                imageList[0].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_dashboard
                    )
                )
                imageList[1].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_products
                    )
                )
                imageList[2].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_orders
                    )
                )
                imageList[3].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_earning
                    )
                )
                imageList[4].setImageDrawable(
                    ContextCompat.getDrawable(
                        this@SellerActivity,
                        R.drawable.ic_profile
                    )
                )
            }
        }
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