package com.sprizen.uashoppingcenter.appenterlogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.ActivityCreateNewAccountBinding

class CreateNewAccountActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateNewAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCreateNewAccountBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        initializeEveryThing()

    }


    //-------------------------------------------------------------------------------------------------------------------

    fun initializeEveryThing(){

        binding.loginBTN.setOnClickListener {
            startActivity(
                Intent(this@CreateNewAccountActivity, LoginActivity :: class.java)
            )
            finish()
        }

    }

}