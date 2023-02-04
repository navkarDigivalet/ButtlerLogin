package com.example.buttlerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buttlerlogin.databinding.ActivityForgot3Binding

class Forgot3Activity : AppCompatActivity() {

    private lateinit var binding : ActivityForgot3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgot3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtGoToLogin.setOnClickListener {
            startActivity(Intent(this@Forgot3Activity,LoginActivity::class.java))
            finish()
        }


    }
}