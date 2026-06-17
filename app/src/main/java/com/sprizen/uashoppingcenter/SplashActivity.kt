package com.sprizen.uashoppingcenter

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.sprizen.uashoppingcenter.LoginSignUpActivities.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<LinearLayout>(R.id.linearLayout)

        val animation =
            AnimationUtils.loadAnimation(this, R.anim.zoom_in_out)

        logo.startAnimation(animation)

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(
                Intent(this, LoginActivity::class.java)
            )

            finish()

        }, 2000)
    }
}