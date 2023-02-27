package com.projects.mazze_pazzle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.mazze_pazzle.databinding.ActivityLevelsBinding

class LevelsActivity : AppCompatActivity() {
    var first_level=Levels(1,true)
    var second_level=Levels(2,false)
    var third_level=Levels(3,false)
    var fourth_level=Levels(4,false)
    var fifth_level=Levels(5,false)
    lateinit var binding : ActivityLevelsBinding
    private var adapter=LevelsAdapter()
    lateinit var level_list:Array<Levels>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        level_list=Array(5) {
            first_level;
            second_level;
            third_level;
            fourth_level
        }

        setContentView(R.layout.activity_levels)
        binding= ActivityLevelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        }
        private fun init(){
            binding.apply {
                 rcView.layoutManager=LinearLayoutManager(this@LevelsActivity)
                 rcView.adapter=adapter
                  for (i in level_list){
                      adapter.addLevels(i)
                  }
        }
    }


}