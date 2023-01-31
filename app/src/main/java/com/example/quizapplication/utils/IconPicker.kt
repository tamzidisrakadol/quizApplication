package com.example.quizapplication.utils

import com.example.quizapplication.R

object IconPicker {
    val icons = arrayOf(
        R.drawable.book,
        R.drawable.chemistry,
        R.drawable.sports,
        R.drawable.coding,
        R.drawable.parchment,
        R.drawable.map
    )
    var iconIndex = -1

    fun getIcon():Int{
        iconIndex = (iconIndex + 1)%icons.size
        return icons[iconIndex]
    }

}