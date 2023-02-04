package com.example.buttlerlogin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerColorAdapter(private val dataset : List<String>): RecyclerView.Adapter<RecyclerColorAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        //var selectColor: TextView
        var selectColor : ImageView

        init {
            selectColor = view.findViewById(R.id.selectColor)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_color_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


   // holder.selectColor.text =   dataset[position]

  // holder.selectColor.setBackgroundColor(Color.parseColor(dataset[position]))

    holder.selectColor.setBackgroundColor(Color.parseColor(dataset[position]))




    }
}