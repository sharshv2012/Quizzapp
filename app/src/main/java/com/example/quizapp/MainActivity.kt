package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        val etName : EditText = findViewById(R.id.etName)
        btnStart.setOnClickListener {
            if (etName.text.isEmpty()){
                Toast.makeText(this , "Please enter your good name." , Toast.LENGTH_LONG).show()
            }else {
                val intent = Intent(this , quizQuestionsActivity::class.java) // two parameters from where (this) to where (quiz page)
                intent.putExtra(Constants.USER_NAME , etName.text.toString() ) // for sending data to another view

                startActivity(intent)
                finish()
            }
        }
    }
}