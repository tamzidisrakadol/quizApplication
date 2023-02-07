package com.example.quizapplication.adapter

import com.example.quizapplication.model.CategoryModel

interface OnItemClick {
    fun onItemClickListener(categoryModel: CategoryModel)
}