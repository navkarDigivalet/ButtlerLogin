package com.example.buttlerlogin

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Interpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.buttlerlogin.databinding.ActivityAddCategoryBinding


class AddCategoryActivity : AppCompatActivity() {

     //   lateinit var binding : ActivityAddCategoryBinding

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

       /*recyclerShape.layoutManager = GridLayoutManager(this,4,LinearLayoutManager.HORIZONTAL,false)

       recyclerColor.layoutManager = GridLayoutManager(this,6,LinearLayoutManager.HORIZONTAL,false)*/

        // val adap1 = RecyclerColorAdapter(colorList)

        // Log.d("count" , adap1.itemCount.toString())

        recyclerColor.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val pagerSnapHelper1  = PagerSnapHelper()
        pagerSnapHelper1.attachToRecyclerView(recyclerShape)




        val childAdapter : RecyclerColorAdapter = RecyclerColorAdapter(colorList)

       // var list2 = colorList.filterIndexed { index, s -> (index>29) }

        /*var list2 = colorList.slice(0..29)
        var list3 = colorList - list2.toSet()*/

       val list = colorList.chunked(30)

       // val list1 = ArrayList<ParentModel>()
        /*list1.add(ParentModel(list2))
        list1.add(ParentModel(list3))*/

        val pagerSnapHelper2  = PagerSnapHelper()
        pagerSnapHelper2.attachToRecyclerView(recyclerColor)

        /*val indicator : CircleIndicator2 = findViewById(R.id.indicator)
        indicator.attachToRecyclerView(recyclerColor,pagerSnapHelper2)*/

        //recyclerShape.addItemDecoration(CirclePagerIndicatorDecoration())



       // CirclePagerIndicatorDecoration.setIndicatorWidth(16)
        Log.d("dp value" , "${CirclePagerIndicatorDecoration.DP.toString()}")
        recyclerColor.addItemDecoration(CirclePagerIndicatorDecoration())

        val parentAdapter  = ParentRecyclerColorAdapter(list)
        recyclerColor.adapter = parentAdapter




      //  recyclerShape.adapter = RecyclerColorAdapter(colorList)
       // recyclerColor.adapter =  RecyclerColorAdapter(colorList)

    }
}





