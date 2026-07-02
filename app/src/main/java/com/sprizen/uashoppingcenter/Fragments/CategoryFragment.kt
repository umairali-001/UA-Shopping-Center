package com.sprizen.uashoppingcenter.Fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.sprizen.uashoppingcenter.Adapters.AdapterItem
import com.sprizen.uashoppingcenter.DATA_CLASS.ITEM
import com.sprizen.uashoppingcenter.DATA_CLASS.PHOTO
import com.sprizen.uashoppingcenter.DataBase
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var listOfItem: MutableList<ITEM>

    lateinit var imageViewsList: MutableList<ImageView>
    lateinit var ImagesUrlList : MutableList<PHOTO>
    lateinit var dataBase: DataBase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentCategoryBinding.inflate(inflater, container, false)



        initializeEveryThing()

        return binding.root
    }



    private fun initializeEveryThing() {

        ImagesUrlList = ArrayList()
        selectedCategory()
        addImagesToDataBase()
        registerAllimageViews()

    }


    fun selectedCategory(){



        binding.categoryFashionBtn.setOnClickListener {
            cleaAllBg()
            binding.categoryFashionBtn.setBackgroundResource(R.drawable.bg_category)
            setImages("Fashion")
        }
        binding.categoryElectronicBtn.setOnClickListener {
            cleaAllBg()
            binding.categoryElectronicBtn.setBackgroundResource(R.drawable.bg_category)
            setImages("Electronic")
        }
        binding.categoryHomeBtn.setOnClickListener {
            cleaAllBg()
            binding.categoryHomeBtn.setBackgroundResource(R.drawable.bg_category)
        }
        binding.categoryBeautyBtn.setOnClickListener {
            cleaAllBg()
            binding.categoryBeautyBtn.setBackgroundResource(R.drawable.bg_category)
        }
        binding.categorySportBtn.setOnClickListener {
            cleaAllBg()
            binding.categorySportBtn.setBackgroundResource(R.drawable.bg_category)
        }
        binding.categoryBooksBtn.setOnClickListener {
            cleaAllBg()
            binding.categoryBooksBtn.setBackgroundResource(R.drawable.bg_category)
        }
        binding.categoryToysBtn.setOnClickListener {
            cleaAllBg()
            binding.categoryToysBtn.setBackgroundResource(R.drawable.bg_category)
        }
        binding.categoryPetFoodBtn.setOnClickListener {
            cleaAllBg()
            binding.categoryPetFoodBtn.setBackgroundResource(R.drawable.bg_category)
        }


    }
    fun cleaAllBg(){


        binding.categoryFashionBtn.background = null
        binding.categoryHomeBtn.background = null
        binding.categoryBeautyBtn.background = null
        binding.categoryToysBtn.background = null
        binding.categoryBooksBtn.background = null
        binding.categoryElectronicBtn.background = null
        binding.categorySportBtn.background = null
        binding.categoryPetFoodBtn.background = null
    }
    fun registerAllimageViews(){

        imageViewsList = ArrayList()
        imageViewsList.add(binding.trendingImage)
        imageViewsList.add(binding.mensClothing)
        imageViewsList.add(binding.womenClothing)
        imageViewsList.add(binding.kidsClothing)
        imageViewsList.add(binding.footwear)
        imageViewsList.add(binding.watches)
        imageViewsList.add(binding.jewelry)



    }


    fun setImages(category : String){
        ImagesUrlList = dataBase.getData(category)
        if (ImagesUrlList.size>0) {

            for (i in 0..6) {
                val imageUrl =
                    ImagesUrlList[i].photoLink

                Glide.with(this)
                    .load(imageUrl)
                    .into(imageViewsList[i])
            }
        }


    }
    fun addImagesToDataBase(){

        dataBase = DataBase(requireContext())
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782994289/Make_cove_image_for_app_202607011954_ycru7b.jpg","Fashion","Fashion")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782900993/Men_s_clothing_pbdijj.jpg","Mens Cloth", "Fashion")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782900993/Women_s_clothing_hl4dbj.jpg","Women Cloth", "Fashion")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782900992/Kids_g6uhit.jpg","Kids Cloth", "Fashion")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782900992/Footwear_e1p04x.jpg","Footwear", "Fashion")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782900993/Watches_and_Accessories_hjlxgs.jpg","Watches", "Fashion")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782900992/jewelry_asdpqs.jpg","Jewelry", "Fashion")


        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782994289/Cove_image_for_shopping_app_202607012006_chv9xs.jpg","Mobile","Electronic")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782972268/Mobile_ywtd7g.jpg","Mobile","Electronic")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782972267/Laptop_s_ykbuht.jpg","Laptop","Electronic")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782972267/Headphones_tcqrx9.jpg","Headphones","Electronic")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782972267/Cameras_uh7tuy.jpg","Camera","Electronic")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782972268/Smart_Watches_hoyogt.jpg","Smart Wachtes","Electronic")
        dataBase.insert_information("https://res.cloudinary.com/q3pn4aap/image/upload/v1782972267/Home_Appliances_azn8fm.jpg","Home Appliances","Electronic")





    }

}
