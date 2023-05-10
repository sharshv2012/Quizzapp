package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName : TextView = findViewById(R.id.tvName)
        val tvScore :TextView = findViewById(R.id.tvResult)
        val btnFinish : Button = findViewById(R.id.finishBtn)

        tvName.text = " HEY! ${intent.getStringExtra(Constants.USER_NAME)} "
        tvScore.text = intent.getIntExtra(Constants.CORRECT_ANSWERS , 0).toString()

        btnFinish.setOnClickListener{
            startActivity(Intent(this , MainActivity::class.java)) // we can do it in seprate line and like this also :)
        }



    }
}