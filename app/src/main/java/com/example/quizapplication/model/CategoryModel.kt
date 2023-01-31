package com.example.quizapplication.model

import android.graphics.drawable.Drawable

data class CategoryModel(
    val categoryID:String,
    val categoryName:String,
    var questionModel:MutableMap<String,QuestionModel> = mutableMapOf()
)