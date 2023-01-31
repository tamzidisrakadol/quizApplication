package com.example.quizapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapplication.R
import com.example.quizapplication.adapter.CategoryAdapter
import com.example.quizapplication.databinding.ActivityMainBinding
import com.example.quizapplication.model.CategoryModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var adapter: CategoryAdapter
    private var categoryModelList = mutableListOf<CategoryModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        dummyData()

        adapter = CategoryAdapter(categoryModelList,this)
        activityMainBinding.recyclerView.layoutManager = GridLayoutManager(this,2)
        activityMainBinding.recyclerView.adapter = adapter

    }

    private fun dummyData(){
        categoryModelList.add(CategoryModel("General Knowledge"))
        categoryModelList.add(CategoryModel("Science"))
        categoryModelList.add(CategoryModel("Sports"))
        categoryModelList.add(CategoryModel("Programming"))
        categoryModelList.add(CategoryModel("History"))
        categoryModelList.add(CategoryModel("Geography"))
    }

}