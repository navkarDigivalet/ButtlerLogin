package com.example.buttlerlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class AddCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        val colorList = resources.getStringArray(R.array.category_colors).toList()



        val recyclerShape : RecyclerView = findViewById(R.id.recyclerShape)
        val recyclerColor : RecyclerView = findViewById(R.id.recyclerColor)

       // recyclerShape.setHasFixedSize(true)
      // recyclerShape.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

      // recyclerShape.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        //recyclerShape.layoutManager = GridLayoutManager(this,5)

        recyclerShape.layoutManager = GridLayoutManager(this,5,GridLayoutManager.HORIZONTAL,false)

        recyclerColor.layoutManager = GridLayoutManager(this,5,LinearLayoutManager.HORIZONTAL,false)


       /* val pagerSnapHelper  = PagerSnapHelper()

        pagerSnapHelper.attachToRecyclerView(recyclerShape)*/


        recyclerShape.adapter = RecyclerColorAdapter(colorList)
       recyclerColor.adapter =  RecyclerColorAdapter(colorList)

    }
}