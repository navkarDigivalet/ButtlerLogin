package com.example.buttlerlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.buttlerlogin.databinding.ActivityFragmentsBinding
import com.example.buttlerlogin.databinding.ActivityMainBinding
import com.example.buttlerlogin.databinding.FragmentRequestBinding
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class FragmentsActivity : AppCompatActivity() {



    //private lateinit var binding : ActivityFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        val tabLayout : TabLayout = findViewById(R.id.tabLayout1)/*
        val tabReq : TabItem? = findViewById(R.id.tabReq)
        val tabButtler : TabItem? = findViewById(R.id.tabButtler)
        val tabZone : TabItem? = findViewById(R.id.tabZone)
        val tabAccount : TabItem? = findViewById(R.id.tabAccount)*/

        loadFrag(RequestFragment())

        /*tabLayout.setOnClickListener{

            Log.d("Fragment" , "first fragment invoked")

        tabReq?.setOnClickListener{
            loadFrag(RequestFragment(),1)
            Log.d("Fragment" , "first fragment invoked")
        }

        tabButtler?.setOnClickListener {
            loadFrag(ButtlersFragment(),1)
            Log.d("Fragment" , "second fragment invoked")
        }

        }*/

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tab?.position){
                    0 -> {
                        loadFrag(RequestFragment())

                    }
                    1 -> {loadFrag(ButtlersFragment())

                    }
                    2 -> {
                        loadFrag(ZonesFragment())
                    }
                    3 -> {
                        loadFrag(AccountFragment())
                    }
                    else -> {
                        loadFrag(RequestFragment())
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }

    private fun loadFrag(fragment: Fragment)
    {
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

        ft.replace(R.id.frameLayout,fragment)

        ft.commit()


    }
}


