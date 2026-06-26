package com.sprizen.uashoppingcenter.Activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.ActivityAddProductBinding

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding

    lateinit var imageView1: ImageView
    lateinit var imageView2: ImageView
    lateinit var imageView3: ImageView
    lateinit var imageView4: ImageView
    lateinit var imageView5: ImageView
    lateinit var buttonIagePicker: LinearLayout


    var pickMultipleMedia = registerForActivityResult(
        ActivityResultContracts
            .PickMultipleVisualMedia(5)
    ) { uris ->
        if (uris.isEmpty()) {
            Toast.makeText(this@AddProductActivity, "${uris.size}", Toast.LENGTH_SHORT)
        }
        if (uris.size > 0) {
            imageView1.setImageURI(uris[0])
        }
        if (uris.size > 1) {
            imageView2.setImageURI(uris[1])
        }
        if (uris.size > 2) {
            imageView3.setImageURI(uris[2])
        }
        if (uris.size > 3) {
            imageView4.setImageURI(uris[3])
        }
        if (uris.size > 4) {
            imageView5.setImageURI(uris[4])
        } else {
            Toast.makeText(this@AddProductActivity, "There is no Image", Toast.LENGTH_SHORT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeEveryThing()
    }


    fun initializeEveryThing() {


        imageView1 = binding.productImage1
        imageView2 = binding.productImage2
        imageView3 = binding.productImage3
        imageView4 = binding.productImage4
        imageView5 = binding.productImage5
        buttonIagePicker = binding.boxAddImage




        buttonIagePicker.setOnClickListener {
            pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        var counter = 1

        binding.btnNext.setOnClickListener {
            if (counter <= 6) {
                activeScreenNext(counter)
                counter += 1
                binding.tvStepCount1.text = "${counter}/7"
            }
        }

        binding.backBtn.setOnClickListener {

            if (counter > 1) {
                counter -= 1
                activeScreenBack(counter)
                binding.tvStepCount1.text = "${counter}/7"
            }


        }

        var spinnerCategory = binding.categorySpinner
        var spinnerSubCategory = binding.subCategorySpinner

        // 1. Main Category Spinner ke liye default array se adapter banana
        var categoryAdapter = ArrayAdapter.createFromResource(this, R.array.category,R.layout.spinner_selected_item)
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = categoryAdapter

        // 2. Main Category Selection Par Listener Lagana
        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Selected item ka index/position nikalna
                val selectedCategory = parent?.getItemAtPosition(position).toString()

                // Position ke hisab se sahi sub-category resource array ID select karna
                var subCategoryArrayResId = when (selectedCategory) {
                    "Fashion" -> R.array.sub_category_fashion
                    "Electronic" -> R.array.sub_category_electronic
                    "Home" -> R.array.sub_category_home
                    "Beauty" -> R.array.sub_category_beauty
                    "Sport" -> R.array.sub_category_sport
                    "Book" -> R.array.sub_category_book
                    "Toys" -> R.array.sub_category_toys
                    "Automotive" -> R.array.sub_category_automotive
                    "Pet Food" -> R.array.sub_category_pet_food
                    else -> R.array.sub_category_electronic // Default fallback
                }

                // 3. Dynamic Adapter banakar Sub-Category Spinner ko update karna
                var subCategoryAdapter = ArrayAdapter.createFromResource(this@AddProductActivity, subCategoryArrayResId, R.layout.spinner_selected_item)
                subCategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerSubCategory.adapter = subCategoryAdapter
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Kuch select na hone par logic (Isme kuch karne ki zarurat nahi hoti)
            }
        }

    }


    fun activeScreenNext(counter: Int) {

        if (counter == 1) {
            binding.firstLayoutStep1ProductImages.visibility = View.GONE
            binding.secondLayoutStep2PriceInfo.visibility = View.VISIBLE
        }
        if (counter == 2) {
            binding.secondLayoutStep2PriceInfo.visibility = View.GONE
            binding.thirdLayoutStep3StockInfo.visibility = View.VISIBLE
        }
        if (counter == 3) {
            binding.thirdLayoutStep3StockInfo.visibility = View.GONE
            binding.fourthLayoutStep4Description.visibility = View.VISIBLE
        }
        if (counter == 4) {
            binding.fourthLayoutStep4Description.visibility = View.GONE
            binding.fifthLayoutStep5Variants.visibility = View.VISIBLE
        }
        if (counter == 5) {
            binding.fifthLayoutStep5Variants.visibility = View.GONE
            binding.sixthLayoutStep6ShippingInfo.visibility = View.VISIBLE
        }
        if (counter == 6) {
            binding.sixthLayoutStep6ShippingInfo.visibility = View.GONE
            binding.seventhLayoutStep7Preview.visibility = View.VISIBLE
        }

    }

    fun activeScreenBack(decrement: Int) {

        if (decrement == 1) {
            binding.firstLayoutStep1ProductImages.visibility = View.VISIBLE
            binding.secondLayoutStep2PriceInfo.visibility = View.GONE
        }
        if (decrement == 2) {
            binding.secondLayoutStep2PriceInfo.visibility = View.VISIBLE
            binding.thirdLayoutStep3StockInfo.visibility = View.GONE
        }
        if (decrement == 3) {
            binding.thirdLayoutStep3StockInfo.visibility = View.VISIBLE
            binding.fourthLayoutStep4Description.visibility = View.GONE
        }
        if (decrement == 4) {
            binding.fourthLayoutStep4Description.visibility = View.VISIBLE
            binding.fifthLayoutStep5Variants.visibility = View.GONE
        }
        if (decrement == 5) {
            binding.fifthLayoutStep5Variants.visibility = View.VISIBLE
            binding.sixthLayoutStep6ShippingInfo.visibility = View.GONE
        }
        if (decrement == 6) {
            binding.sixthLayoutStep6ShippingInfo.visibility = View.VISIBLE
            binding.seventhLayoutStep7Preview.visibility = View.GONE
        }

    }


}