package com.example.quizapp

data class Question(
    val id : Int ,
    val question : String ,
    val image : Int ,
    val opt1 : String,
    val opt2 : String,
    val opt3 : String,
    val opt4 : String,
    val correctAns :Int
)
