package com.example.buttlerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.buttlerlogin.databinding.ActivityForgot1Binding

class Forgot1Activity : AppCompatActivity() {

    private lateinit var binding : ActivityForgot1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgot1Binding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.back1.setOnClickListener {
            startActivity(Intent(this@Forgot1Activity,LoginActivity::class.java))
            finish()
        }


        binding.btnReset.setOnClickListener {

            val email = binding.edtForgot1.text.toString()

            if (LoginActivity.checkMail(email)) {
                startActivity(Intent(this@Forgot1Activity, Forgot2Activity::class.java))
                 }
            else
                Toast.makeText(this@Forgot1Activity,"Enter correct mail" , Toast.LENGTH_SHORT).show()
        }
    }
}