package com.sprizen.uashoppingcenter.Activities

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.sprizen.uashoppingcenter.Fragments.CartFragment
import com.sprizen.uashoppingcenter.Fragments.DiscoverFragment
import com.sprizen.uashoppingcenter.Fragments.HomeFragment
import com.sprizen.uashoppingcenter.Fragments.ProfileFragment
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    lateinit var fragmentList: MutableList<Fragment>
    lateinit var imageList : MutableList<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        initializeEveryThing()

    }

    //===================================================================================================================

    fun initializeEveryThing(){





        imageList = ArrayList()

        var home = findViewById<ImageView>(R.id.homeBT)
        var explore = findViewById<ImageView>(R.id.exploreBT)
        var fav = findViewById<ImageView>(R.id.favBT)
        var profile = findViewById<ImageView>(R.id.profileBT)
        imageList.add(home)
        imageList.add(explore)
        imageList.add(fav)
        imageList.add(profile)


        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R.color.accent_orange))





        setUpViewPager()
        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                TabLayout.INDICATOR_ANIMATION_MODE_ELASTIC
                binding.viewPager.currentItem = tab.position
                when(tab.position) {
                    0 -> {
                        imageList[0].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity,
                                R.color.accent_orange
                            )
                        )
                        imageList[1].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[2].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[3].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                    }

                    1 -> {
                        imageList[0].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[1].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.accent_orange
                            )
                        )
                        imageList[2].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[3].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                    }

                    2 -> {
                        imageList[0].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[1].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[2].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.accent_orange
                            )
                        )
                        imageList[3].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                    }

                    3 -> {
                        imageList[0].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[1].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[2].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.white
                            )
                        )
                        imageList[3].setColorFilter(
                            ContextCompat.getColor(
                                this@HomeActivity, R
                                    .color.accent_orange
                            )
                        )
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 ->{
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                    }
                    1-> {
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                    }
                    2->{
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                    }
                    3->{
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                    }
                }

            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 ->{
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                    }
                    1-> {
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                    }
                    2->{
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                    }
                    3->{
                        imageList[0].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[1].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[2].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.white))
                        imageList[3].setColorFilter(ContextCompat.getColor(this@HomeActivity, R
                            .color.accent_orange))
                    }
                }
            }

        })

        binding.viewPager.registerOnPageChangeCallback(object  : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {

                binding.tabLayout.getTabAt(position)?.select()
            }

        })












    }




    fun setUpViewPager() {
        fragmentList = ArrayList()

        var firstF = HomeFragment()
        var secondF = DiscoverFragment()
        var thridF = CartFragment()
        var fourthF = ProfileFragment()

        fragmentList.add(firstF)
        fragmentList.add(secondF)
        fragmentList.add(thridF)
        fragmentList.add(fourthF)


        var fragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle, fragmentList)

        binding.viewPager.adapter = fragmentAdapter


    }

    class FragmentAdapter(
        fragmentManager: FragmentManager, lifecycle: Lifecycle,
        fragmentList:
        MutableList<Fragment>,
    ) : FragmentStateAdapter(fragmentManager, lifecycle) {

        var fragmentList: MutableList<Fragment>

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