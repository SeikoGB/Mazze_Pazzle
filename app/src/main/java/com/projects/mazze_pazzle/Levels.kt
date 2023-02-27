package com.projects.mazze_pazzle

data class Levels(var level_number:Int,var isEnabel:Boolean){
    lateinit var level:Array<IntArray>
    fun addLevel_Matrix(temp_level: Array<IntArray>){
        level=temp_level
    }
}
