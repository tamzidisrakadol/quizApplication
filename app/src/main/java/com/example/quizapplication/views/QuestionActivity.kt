package com.example.quizapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizapplication.databinding.ActivityQuestionBinding
import com.example.quizapplication.model.CategoryModel
import com.example.quizapplication.model.QuestionModel
import com.google.firebase.firestore.FirebaseFirestore

class QuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestionBinding
    private var categoryList = mutableListOf<CategoryModel>()
    private var questions = mutableMapOf<String, QuestionModel>()
    private var index = 1 //should be start from 1 because quiz question in firebase start from 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpQuesFromFireStore()
    }


    private fun setUpQuesFromFireStore() {
        val fireStore = FirebaseFirestore.getInstance()
        val category = intent.getStringExtra("category")
        if (category != null) {
            fireStore.collection("categories").whereEqualTo("categoryName", category)
                .get()
                .addOnSuccessListener {
                    if (it != null && !it.isEmpty) {
                        categoryList = it.toObjects(CategoryModel::class.java)
                        questions = categoryList[0].questionModel
                        //Log.d("tag","$questions")
                        val ques = questions["question$index"]
                        
                        if (ques!=null){
                            binding.questionTV.text = ques.questionDesc
                        }

                    }
                }
        }

    }
}


