package com.example.quizapplication.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapplication.R
import com.example.quizapplication.adapter.CategoryAdapter
import com.example.quizapplication.adapter.OnItemClick
import com.example.quizapplication.databinding.ActivityMainBinding
import com.example.quizapplication.model.CategoryModel
import com.example.quizapplication.model.QuestionModel
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity(), OnItemClick {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var adapter: CategoryAdapter
    private var categoryModelList = mutableListOf<CategoryModel>()
    private lateinit var firestore: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        setupFireStore()
        adapter = CategoryAdapter(categoryModelList, this,this)
        activityMainBinding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        activityMainBinding.recyclerView.adapter = adapter

    }

    private fun setupFireStore() {
        firestore = FirebaseFirestore.getInstance()
        val categoryRef = firestore.collection("categories")
        categoryRef.get().addOnSuccessListener {
            for (document in it) {
                val category = document.toObject(CategoryModel::class.java)
                categoryModelList.add(category)
                Log.d("Quiz","Ques $category")
            }
            adapter.notifyDataSetChanged()
        }

    }

    override fun onItemClickListener(categoryModel: CategoryModel) {
        var categoryName = categoryModel.categoryName
        val intent = Intent(this,QuestionActivity::class.java)
        intent.putExtra("category",categoryName)
        startActivity(intent)

    }

}