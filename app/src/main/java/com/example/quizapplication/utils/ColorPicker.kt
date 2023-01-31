package com.example.quizapplication.utils

object ColorPicker {
    val colors = listOf("#FF0000", "#FFFF00", "#4CC417", "#00BFFF", "#FFA600", "#9D00FF")
    var colorIndex = -1

    fun getColor(): String {
        colorIndex = (colorIndex+1)% colors.size
        return colors[colorIndex]
    }
}