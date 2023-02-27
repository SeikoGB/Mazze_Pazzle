package com.projects.mazze_pazzle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import com.projects.mazze_pazzle.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding
    lateinit var up: Button
    lateinit var down: Button
    lateinit var right: Button
    lateinit var left: Button
    lateinit var map:ArrayList<Rows>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        UI()
        binding= ActivityGameBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
         lateinit var level_list:ArrayList<Levels>
         lateinit var curent_level:Levels
         val first_level=Levels(1,true)
         val first_level_matrix=Array(10){
            IntArray(10){0;0;0;0;0;0;1;0;0;0};
            IntArray(10){0;0;0;1;1;1;1;1;1;0};
            IntArray(10){0;1;1;1;0;0;1;0;0;0};
            IntArray(10){0;1;0;0;0;0;1;1;1;0};
            IntArray(10){0;1;1;1;1;1;0;0;1;0};
            IntArray(10){0;0;0;0;1;1;1;0;1;0};
            IntArray(10){0;1;1;1;1;0;1;1;1;0};
            IntArray(10){0;1;0;0;1;0;1;0;1;0};
            IntArray(10){0;1;1;0;0;0;1;0;0;0};
            IntArray(10){0;0;0;0;0;0;1;0;0;0}
        }
        first_level.addLevel_Matrix(first_level_matrix)
        var level_number=0;
        level_list.add(first_level)
        for (i in level_list) {
            if(level_number==i.level_number){
            curent_level = i
            curent_level.addLevel_Matrix(i.level)
            break
            }
        }
        var curentX=9
        var curentY=4
        var finishX=0
        var finishY=5
        fillField(curent_level,map)
        up.setOnClickListener(){
            moveUp(curent_level,map,curentX,curentY)
        }
        right.setOnClickListener(){
            moveRight(curent_level,map,curentX,curentY)
        }
        down.setOnClickListener(){
            moveDown(curent_level,map,curentX,curentY)
        }
        left.setOnClickListener(){
            moveLeft(curent_level,map,curentX,curentY)
        }

    }



    private fun moveUp(level:Levels,map:ArrayList<Rows>,curentX:Int,curentY:Int){
        if (level.level[curentX+1][curentY]==0){
            map[curentX+1].images[curentY].setImageResource(R.drawable.character)
            map[curentX+1].images[curentY].setImageResource(R.drawable.earth)
        }
    }
    private fun moveDown(level:Levels,map:ArrayList<Rows>,curentX:Int,curentY:Int){
        if (level.level[curentX-1][curentY]==0){
            map[curentX-1].images[curentY].setImageResource(R.drawable.character)
            map[curentX].images[curentY].setImageResource(R.drawable.earth)
        }
    }
    private fun moveLeft(level:Levels,map:ArrayList<Rows>,curentX:Int,curentY:Int){
        if (level.level[curentX][curentY+1]==0){
            map[curentX].images[curentY+1].setImageResource(R.drawable.character)
            map[curentX].images[curentY].setImageResource(R.drawable.earth)
        }
    }
    private fun moveRight(level:Levels,map:ArrayList<Rows>,curentX:Int,curentY:Int){
        if (level.level[curentX][curentY-1]==0){
            map[curentX].images[curentY-1].setImageResource(R.drawable.character)
            map[curentX].images[curentY].setImageResource(R.drawable.earth)
        }
    }

    private fun fillField(level:Levels,map:ArrayList<Rows>){
        for (i in 0..level.level.size-1){
        for (j in 0..level.level[i].size-1){
            if (level.level[i][j]==0){
                map[i].images[j].setImageResource(R.drawable.earth)
            }
            else if(level.level[i][j]==1){
                map[i].images[j].setImageResource(R.drawable.earth)
            }
            else if (level.level[i][j]==-1){
                map[i].images[j].setImageResource(R.drawable.finish_line)
            }
            else if (level.level[i][j]==1){
                map[i].images[j].setImageResource(R.drawable.character)
            }
        }
        }
    }
    private fun fillRow(row_number:Int,row_arr:ArrayList<ImageView>):Rows{
        var temp_row:Rows
        binding.apply {
         temp_row=Rows(row_number,row_arr)
        }
        return temp_row
    }
    private fun isWin(finishX:Int,finishY:Int,curentX: Int,curentY: Int,level: Levels){
        if (level.level[curentX][curentY]==level.level[finishX][finishY]){
            up.isClickable=false
            right.isClickable=false
            down.isClickable=false
            up.isClickable=false
        }
    }
    private fun UI(){
          right = findViewById(R.id.right)
        up = findViewById(R.id.up)
        down = findViewById(R.id.down)
        left=findViewById(R.id.left)

        binding.apply {
            lateinit var row1_arr: ArrayList<ImageView>
            lateinit  var row2_arr: ArrayList<ImageView>
            lateinit var row3_arr: ArrayList<ImageView>
            lateinit  var row4_arr: ArrayList<ImageView>
            lateinit  var row5_arr: ArrayList<ImageView>
            lateinit var row6_arr: ArrayList<ImageView>
            lateinit var row7_arr: ArrayList<ImageView>
            lateinit var row8_arr: ArrayList<ImageView>
            lateinit var row9_arr: ArrayList<ImageView>
            lateinit var row10_arr: ArrayList<ImageView>

            row1_arr.add(row1Img1)
            row1_arr.add(row1Img2)
            row1_arr.add(row1Img3)
            row1_arr.add(row1Img4)
            row1_arr.add(row1Img5)
            row1_arr.add(row1Img6)
            row1_arr.add(row1Img7)
            row1_arr.add(row1Img8)
            row1_arr.add(row1Img9)
            row1_arr.add(row1Img10)
            row2_arr.add(row2Img1)
            row2_arr.add(row2Img2)
            row2_arr.add(row2Img3)
            row2_arr.add(row2Img4)
            row2_arr.add(row2Img5)
            row2_arr.add(row2Img6)
            row2_arr.add(row2Img7)
            row2_arr.add(row2Img8)
            row2_arr.add(row2Img9)
            row2_arr.add(row2Img10)
            row3_arr.add(row3Img1)
            row3_arr.add(row3Img2)
            row3_arr.add(row3Img3)
            row3_arr.add(row3Img4)
            row3_arr.add(row3Img5)
            row3_arr.add(row3Img6)
            row3_arr.add(row3Img7)
            row3_arr.add(row3Img8)
            row3_arr.add(row3Img9)
            row3_arr.add(row3Img10)
            row4_arr.add(row4Img1)
            row4_arr.add(row4Img2)
            row4_arr.add(row4Img3)
            row4_arr.add(row4Img4)
            row4_arr.add(row4Img5)
            row4_arr.add(row4Img6)
            row4_arr.add(row4Img7)
            row4_arr.add(row4Img8)
            row4_arr.add(row4Img9)
            row4_arr.add(row4Img10)
            row5_arr.add(row5Img1)
            row5_arr.add(row5Img2)
            row5_arr.add(row5Img3)
            row5_arr.add(row5Img4)
            row5_arr.add(row5Img5)
            row5_arr.add(row5Img6)
            row5_arr.add(row5Img7)
            row5_arr.add(row5Img8)
            row5_arr.add(row5Img9)
            row5_arr.add(row5Img10)
            row6_arr.add(row6Img1)
            row6_arr.add(row6Img2)
            row6_arr.add(row6Img3)
            row6_arr.add(row6Img4)
            row6_arr.add(row6Img5)
            row6_arr.add(row6Img6)
            row6_arr.add(row6Img7)
            row6_arr.add(row6Img8)
            row6_arr.add(row6Img9)
            row6_arr.add(row6Img10)
            row7_arr.add(row7Img1)
            row7_arr.add(row7Img2)
            row7_arr.add(row7Img3)
            row7_arr.add(row7Img4)
            row7_arr.add(row7Img5)
            row7_arr.add(row7Img6)
            row7_arr.add(row7Img7)
            row7_arr.add(row7Img8)
            row7_arr.add(row7Img9)
            row7_arr.add(row7Img10)
            row8_arr.add(row8Img1)
            row8_arr.add(row8Img1)
            row8_arr.add(row8Img2)
            row8_arr.add(row8Img3)
            row8_arr.add(row8Img4)
            row8_arr.add(row8Img5)
            row8_arr.add(row8Img6)
            row8_arr.add(row8Img7)
            row8_arr.add(row8Img8)
            row8_arr.add(row8Img9)
            row8_arr.add(row8Img10)
            row9_arr.add(row9Img1)
            row9_arr.add(row9Img2)
            row9_arr.add(row9Img3)
            row9_arr.add(row9Img4)
            row9_arr.add(row9Img5)
            row9_arr.add(row9Img6)
            row9_arr.add(row9Img7)
            row9_arr.add(row9Img8)
            row9_arr.add(row9Img9)
            row9_arr.add(row9Img10)
            row10_arr.add(row10Img1)
            row10_arr.add(row10Img2)
            row10_arr.add(row10Img3)
            row10_arr.add(row10Img4)
            row10_arr.add(row10Img5)
            row10_arr.add(row10Img6)
            row10_arr.add(row10Img7)
            row10_arr.add(row10Img8)
            row10_arr.add(row10Img9)
            row10_arr.add(row10Img10)
            var first_row:Rows=fillRow(row1.tag.toString().toInt(),row1_arr)
            var second_row:Rows=fillRow(row2.tag.toString().toInt(),row2_arr)
            var third_row:Rows=fillRow(row3.tag.toString().toInt(),row3_arr)
            var fourth_row:Rows=fillRow(row4.tag.toString().toInt(),row4_arr)
            var fifth_row:Rows=fillRow(row5.tag.toString().toInt(),row5_arr)
            var sixth_row:Rows=fillRow(row6.tag.toString().toInt(),row6_arr)
            var seventh_row:Rows=fillRow(row7.tag.toString().toInt(),row7_arr)
            var eighth_row:Rows=fillRow(row8.tag.toString().toInt(),row8_arr)
            var nineth_row:Rows=fillRow(row9.tag.toString().toInt(),row9_arr)
            var tenth_row:Rows=fillRow(row10.tag.toString().toInt(),row10_arr)
            map.add(first_row)
            map.add(second_row)
            map.add(third_row)
            map.add(fourth_row)
            map.add(fifth_row)
            map.add(sixth_row)
            map.add(seventh_row)
            map.add(eighth_row)
            map.add(nineth_row)
            map.add(tenth_row)
        }
}
}