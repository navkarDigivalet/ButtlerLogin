package com.example.buttlerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.buttlerlogin.databinding.ActivityForgot2Binding

class Forgot2Activity : AppCompatActivity() {

   private lateinit var binding : ActivityForgot2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgot2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.txtGoToEmail.setOnClickListener {
            startActivity(Intent(this,Forgot3Activity::class.java))
            finish()
        }

        binding.back2.setOnClickListener {
            startActivity(Intent(this@Forgot2Activity,Forgot1Activity::class.java))
            finish()
        }
    }
}