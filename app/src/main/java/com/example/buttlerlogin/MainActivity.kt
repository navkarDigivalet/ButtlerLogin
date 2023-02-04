package com.example.buttlerlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.buttlerlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = Intent(this, LoginActivity::class.java)

        binding.linearLayout1.setOnClickListener{
            startActivity(intent)
        }



        binding.linearLayout2.setOnClickListener {

            startActivity(Intent(this@MainActivity,AddCategoryActivity::class.java))
        }

        binding.linearLayout3.setOnClickListener {

            startActivity(Intent(this@MainActivity,AfterLoginActivity::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("On pause","On pause invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.d("On Stop","On Stop invoked")
    }

    override fun onResume() {
        super.onResume()
        Log.d("On Resume","On Resume invoked")
    }
}