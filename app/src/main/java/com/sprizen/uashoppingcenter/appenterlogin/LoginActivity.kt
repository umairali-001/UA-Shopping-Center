package com.sprizen.uashoppingcenter.appenterlogin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        initializeEveryThing()


    }

    //-------------------------------------------------------------------------------------------------------------------

    fun initializeEveryThing(){

        binding.regBT.setOnClickListener {
            startActivity(
                Intent(this@LoginActivity, CreateNewAccountActivity :: class.java)
            )
            finish()
        }
    }
}