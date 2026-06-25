package com.sprizen.uashoppingcenter.Activities

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sprizen.uashoppingcenter.R
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import com.sprizen.uashoppingcenter.databinding.ActivityAddProductBinding
import kotlin.random.Random

class AddProductActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddProductBinding

    lateinit var imageView1 : ImageView
    lateinit var imageView2 : ImageView
    lateinit var imageView3 : ImageView
    lateinit var imageView4 : ImageView
    lateinit var imageView5 : ImageView
    lateinit var buttonIagePicker  : LinearLayout



    var pickMultipleMedia = registerForActivityResult(ActivityResultContracts
        .PickMultipleVisualMedia(5)){
            uris ->
        if(uris.isEmpty()){
            Toast.makeText(this@AddProductActivity,"${uris.size}", Toast.LENGTH_SHORT)
        }
        if(uris.size>0){
            imageView1.setImageURI(uris[0])
        }
        if(uris.size>1 ){
            imageView2.setImageURI(uris[1])
        }
        if(uris.size>2 ){
            imageView3.setImageURI(uris[2])
        }
        if(uris.size>3 ){
            imageView4.setImageURI(uris[3])
        }
        if(uris.size>4 ){
            imageView5.setImageURI(uris[4])
        }
        else{
            Toast.makeText(this@AddProductActivity,"There is no Image", Toast.LENGTH_SHORT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeEveryThing()
    }


    fun initializeEveryThing(){



        imageView1 = binding.productImage1
        imageView2 = binding.productImage2
        imageView3 = binding.productImage3
        imageView4 = binding.productImage4
        imageView5 = binding.productImage5
        buttonIagePicker = binding.boxAddImage




        buttonIagePicker.setOnClickListener {
            pickMultipleMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        var counter  = 1

        binding.btnNext.setOnClickListener {
            if(counter<=6){
                activeScreenNext(counter)
                counter+=1
                binding.tvStepCount1.text ="${counter}/7"
            }

        binding.backBtn.setOnClickListener {

            if(counter>1){
                counter-=1
                activeScreenBack(counter)
                binding.tvStepCount1.text ="${counter}/7"
            }


        }








        }






    }











    fun activeScreenNext(counter : Int){

        if(counter==1){
            binding.firstLayoutStep1ProductImages.visibility= View.GONE
            binding.secondLayoutStep2PriceInfo.visibility= View.VISIBLE
        }
        if(counter==2){
            binding.secondLayoutStep2PriceInfo.visibility= View.GONE
            binding.thirdLayoutStep3StockInfo.visibility= View.VISIBLE
        }
        if(counter==3){
            binding.thirdLayoutStep3StockInfo.visibility= View.GONE
            binding.fourthLayoutStep4Description.visibility= View.VISIBLE
        }
        if(counter==4){
            binding.fourthLayoutStep4Description.visibility= View.GONE
            binding.fifthLayoutStep5Variants.visibility= View.VISIBLE
        }
        if(counter==5){
            binding.fifthLayoutStep5Variants.visibility= View.GONE
            binding.sixthLayoutStep6ShippingInfo.visibility= View.VISIBLE
        }
        if(counter==6){
            binding.sixthLayoutStep6ShippingInfo.visibility= View.GONE
            binding.seventhLayoutStep7Preview.visibility= View.VISIBLE
        }

    }

    fun activeScreenBack(decrement : Int){

        if(decrement==1){
            binding.firstLayoutStep1ProductImages.visibility= View.VISIBLE
            binding.secondLayoutStep2PriceInfo.visibility= View.GONE
        }
        if(decrement==2){
            binding.secondLayoutStep2PriceInfo.visibility= View.VISIBLE
            binding.thirdLayoutStep3StockInfo.visibility= View.GONE
        }
        if(decrement==3){
            binding.thirdLayoutStep3StockInfo.visibility= View.VISIBLE
            binding.fourthLayoutStep4Description.visibility= View.GONE
        }
        if(decrement==4){
            binding.fourthLayoutStep4Description.visibility= View.VISIBLE
            binding.fifthLayoutStep5Variants.visibility= View.GONE
        }
        if(decrement==5){
            binding.fifthLayoutStep5Variants.visibility= View.VISIBLE
            binding.sixthLayoutStep6ShippingInfo.visibility= View.GONE
        }
        if(decrement==6){
            binding.sixthLayoutStep6ShippingInfo.visibility= View.VISIBLE
            binding.seventhLayoutStep7Preview.visibility= View.GONE
        }

    }










}