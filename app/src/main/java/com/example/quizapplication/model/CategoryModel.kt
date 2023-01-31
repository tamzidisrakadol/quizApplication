package com.example.quizapplication.model



data class CategoryModel(
    val categoryID:String ="",
    val categoryName:String ="",
    var questionModel:MutableMap<String,QuestionModel> = mutableMapOf()
)