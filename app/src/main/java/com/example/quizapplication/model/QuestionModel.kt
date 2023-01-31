package com.example.quizapplication.model

data class QuestionModel(
    var questionDesc:String="",
    var quesOpt1:String="",
    var quesOpt2:String="",
    var quesOpt3:String="",
    var quesOpt4:String="",
    var quesAns:String="",
    var userAns:String=""
)