package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class quizQuestionsActivity : AppCompatActivity() , View.OnClickListener{

    
    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var progressbar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null
    private var tvOption1 : TextView? =null
    private var tvOption2 : TextView? =null
    private var tvOption3 : TextView? =null
    private var tvOption4 : TextView? =null
    private var buttonSubmit : Button? = null
    private var mUserName : String? = null
    private var mCorrectAns : Int = 0 // no. of correct answers.


        @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME) // for getting data from another view.
        progressbar = findViewById(R.id.progBar)
        tvProgress = findViewById(R.id.tvProg)
        tvQuestion = findViewById(R.id.tvQues)
        ivImage = findViewById(R.id.ivFlag)
        tvOption1= findViewById(R.id.tvOpt1)
        tvOption2 = findViewById(R.id.tvOpt2)
        tvOption3 = findViewById(R.id.tvOpt3)
        tvOption4 = findViewById(R.id.tvOpt4)
        buttonSubmit = findViewById(R.id.btnSubmit)
        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        buttonSubmit?.setOnClickListener(this)
        mQuestionsList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
       /* Log.i("questionsList size is ", "${questionsList.size}")

        for (i in questionsList) {
            Log.e("Questions", i.question)
        }  used for getting log*/


        defaultOptionsView() // it is called so that we can reset colors after question changes

        val ques: Question = mQuestionsList!![mCurrentPosition - 1] // because mqueslist is nullable we use !! and we are sure it wont be empty
        progressbar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressbar?.max}"
        tvQuestion?.text = ques.question
        tvOption1?.text = ques.opt1
        tvOption2?.text = ques.opt2
        tvOption3?.text = ques.opt3
        tvOption4?.text = ques.opt4
        ivImage?.setImageResource(ques.image)

        if(mCurrentPosition == mQuestionsList!!.size){ 
            buttonSubmit?.text = "FINISH"
        }else{
            buttonSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0 , it)
        }
        tvOption2?.let{
            options.add(1 , it)
        }
        tvOption3?.let{
            options.add(2 , it)
        }
        tvOption4?.let{
            options.add(3 , it)
        }

        for (option in options ){
            option.setTextColor(Color.parseColor("#7A8089"))

            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable( this ,
                R.drawable.default_option_border_bg )
        }
    }
    private fun selectedOptionView (tv:TextView , selectedOptionNum :Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface , Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this ,
            R.drawable.selected_option_border_bg
        )
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvOpt1 -> {
                tvOption1?.let {
                    selectedOptionView(it , 1)
                }

            }
            R.id.tvOpt2 -> {
                tvOption2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tvOpt3 -> {
                tvOption3?.let {
                    selectedOptionView(it, 3)
                }

            }
            R.id.tvOpt4 -> {
                tvOption4?.let {
                    selectedOptionView(it, 4)
                }

            }
            R.id.btnSubmit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this , ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME , mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS , mCorrectAns)
                            startActivity(intent)
                            finish()

                        }
                    }

                }else{
                    val question  = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAns != mSelectedOptionPosition){

                        answerView(mSelectedOptionPosition , R.drawable.wrong_option_border_bg)

                    }else{
                        mCorrectAns++
                    }
                    answerView(question.correctAns , R.drawable.correct_option_border_bg )
                    if(mCurrentPosition == mQuestionsList!!.size){
                        buttonSubmit?.text = "FINISH"
                    }else{
                        buttonSubmit?.text = "GO TO THE NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }
    }
    private fun answerView(answer : Int , drawableView: Int){
        when (answer){

            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(
                    this , drawableView
                )
            }

            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(
                    this , drawableView
                )
            }
            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(
                    this , drawableView
                )
            }
            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(
                    this , drawableView
                )
            }
        }
    }

}