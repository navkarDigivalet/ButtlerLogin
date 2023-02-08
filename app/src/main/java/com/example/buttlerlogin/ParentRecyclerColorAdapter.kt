package com.example.buttlerlogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView




class ParentRecyclerColorAdapter(private val dataset : List<List<String>>): RecyclerView.Adapter<ParentRecyclerColorAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {

        val childRecyclerColor : RecyclerView

        init {

            childRecyclerColor = view.findViewById(R.id.child_recycler_color)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler_color,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        val childAdapter :RecyclerColorAdapter = RecyclerColorAdapter(dataset[position])

        /*holder.childRecyclerColor.layoutManager = LinearLayoutManager(holder.childRecyclerColor.context,
            LinearLayoutManager.HORIZONTAL,false)*/

        holder.childRecyclerColor.layoutManager = GridLayoutManager(holder.childRecyclerColor.context,
          5,  LinearLayoutManager.VERTICAL,false)

        holder.childRecyclerColor.adapter = childAdapter

        /*childAdapter.notifyDataSetChanged()*/



    }
}