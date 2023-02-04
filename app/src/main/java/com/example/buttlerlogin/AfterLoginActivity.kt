package com.example.buttlerlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.buttlerlogin.databinding.ActivityAfterLoginBinding

class AfterLoginActivity : AppCompatActivity() {

   private lateinit var binding : ActivityAfterLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAfterLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadFrag(RequestFragment())

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.requests ->{
                    loadFrag(RequestFragment())
                    true
                }

                R.id.buttlers ->{
                    loadFrag(ButtlersFragment())
                    true
                }

                R.id.zones ->{
                    loadFrag(ZonesFragment())
                    true
                }

                R.id.account -> {
                    loadFrag(AccountFragment())
                    true
                }
                else -> {
                    loadFrag(RequestFragment())
                    true
                }
            }

        }
    }

    private fun loadFrag(fragment: Fragment)
    {
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

        ft.replace(R.id.frameLayout,fragment)

        ft.commit()


    }
}