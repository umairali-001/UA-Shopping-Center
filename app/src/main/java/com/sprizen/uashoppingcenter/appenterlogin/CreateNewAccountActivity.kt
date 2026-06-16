package com.sprizen.uashoppingcenter.appenterlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.sprizen.uashoppingcenter.HomeActivity
import com.sprizen.uashoppingcenter.R
import com.sprizen.uashoppingcenter.databinding.ActivityCreateNewAccountBinding
import kotlin.toString

class CreateNewAccountActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateNewAccountBinding

    var firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCreateNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeEverything()
    }
    fun initializeEverything() {

// chack uers
        if (firebaseAuth.currentUser != null){
            startActivity(Intent(this@CreateNewAccountActivity, HomeActivity::class.java))
            finish()
        }

        binding.logBT.setOnClickListener {
            finish()
            startActivity(Intent(this@CreateNewAccountActivity, LoginActivity::class.java))
        }
        binding.SignBT.setOnClickListener {
            signpage()
        }

    }

    fun signpage(){
        val email=binding.emailET.text.toString()
        val password=binding.passwordET.text.toString()
        val confirm_password=binding.CpasswordET.text.toString()

        if (email.isEmpty()||password.isEmpty()||confirm_password.isEmpty()){
            Toast.makeText(this@CreateNewAccountActivity,"Error please enter all detail",Toast.LENGTH_SHORT).show()
            return
        }
        if (password  != confirm_password){
            Toast.makeText(this@CreateNewAccountActivity,"Error incorrect password",Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {
            if (it.isSuccessful){
                startActivity(Intent(this@CreateNewAccountActivity, HomeActivity::class.java))
                finish()
            }else{
                Toast.makeText(this@CreateNewAccountActivity,it.exception?.message,Toast.LENGTH_SHORT).show()
            }

        }
    }

}