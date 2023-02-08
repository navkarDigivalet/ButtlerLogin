package com.example.buttlerlogin

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.buttlerlogin.databinding.ActivityAddCategoryBinding
import com.example.buttlerlogin.databinding.ActivityMainBinding
import com.example.buttlerlogin.databinding.RecyclerColorItemBinding

var selectedColor : Int = Color.parseColor("#DF1125")

class RecyclerColorAdapter(private val dataset : List<String>): RecyclerView.Adapter<RecyclerColorAdapter.ViewHolder>(){

    var lastClickedPosition = 0
    lateinit var binding : RecyclerColorItemBinding


    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        //var selectColor: TextView
       // var selectColor : ImageView
         var viewColor : View
         var innerLayout : View

        init {
         //   selectColor = view.findViewById(R.id.selectColor)
            viewColor = view.findViewById(R.id.viewColor)
            innerLayout = view.findViewById(R.id.inner_layout)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_color_item,parent,false)

        /*ViewHolder(view).inner_layout.setOnClickListener {
            ViewHolder(view).inner_layout.setBackgroundResource(R.drawable.color_bg_on_select)
        }*/

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


   // holder.selectColor.text =   dataset[position]

  // holder.selectColor.setBackgroundColor(Color.parseColor(dataset[position]))

      //  holder.viewColor.setBackgroundResource(R.drawable.color_bg)
       // holder.viewColor.setBackgroundColor(Color.parseColor(dataset[position]))

        /*val gradientDrawable = (holder.viewColor.getBackground() as GradientDrawable).mutate()
        (gradientDrawable as GradientDrawable).setColor(Color.LTGRAY)*/




      /*  holder.inner_layout.setOnClickListener {
            holder.inner_layout.setBackgroundResource(R.drawable.color_bg_on_select)
        }*/


            val gradientDrawable = (holder.viewColor.background).mutate() as GradientDrawable
            gradientDrawable.setColor(Color.parseColor(dataset[position]))




        /*holder.innerLayout.setOnClickListener {
            lastClickedPosition = position
            notifyDataSetChanged()

        }




        if(lastClickedPosition==position){
            holder.innerLayout.setBackgroundResource(R.drawable.color_bg_on_select)
            selectedColor = Color.parseColor(dataset[position])
        }*/


    }


}
