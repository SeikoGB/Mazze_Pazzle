package com.projects.mazze_pazzle

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projects.mazze_pazzle.databinding.LevelItemBinding

class LevelsAdapter:RecyclerView.Adapter<LevelsAdapter.LevelsHolder>() {
    val level_list= ArrayList<Levels>()

    class LevelsHolder(Item:View):RecyclerView.ViewHolder(Item) {
        val binding=LevelItemBinding.bind(Item)
        fun bind(levels: Levels)= with(binding){
               levelNumber.text= levels.level_number.toString()
               if (levels.isEnabel==false){
                   card.isEnabled=false
                   cLayout.setBackgroundColor(Color.GRAY)
               }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.level_item,parent,false)
        return LevelsHolder(view)
    }

    override fun onBindViewHolder(holder: LevelsHolder, position: Int) {
          holder.bind(level_list[position])
    }

    override fun getItemCount(): Int {
        return level_list.size
    }

    fun addLevels(level: Levels){
        level_list.add(level)
        notifyDataSetChanged()
    }
}