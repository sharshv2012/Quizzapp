package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWERS :String = "correct_answers"


    fun getQuestions() : ArrayList<Question>{
        val QuestionList = ArrayList<Question>()

        val ques1 = Question(
            1 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_argentina, "Argentina" , "India" , "Papua New Guinea" ,
            "Myanmar" , 1
        )
        QuestionList.add(ques1)

        val ques2 = Question(
            2 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_cambodia,"U.S.A" , "India" , "Cambodia" ,
            "Brazil" , 3
        )
        QuestionList.add(ques2)

        val ques3 = Question(
            3 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_brazil, "Armenia" , "Brazil" , "U.K." ,
            "Australia" , 2
        )
        QuestionList.add(ques3)

        val ques4 = Question(
            4 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_barbados, "Barbados" , "Norway" , "U.K." ,
            "Greece" , 1
        )
        QuestionList.add(ques4)

        val ques5 = Question(
            5 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_cuba, "Brazil" , "Ukraine" , "Morocco" ,
            "Cuba", 4
        )
        QuestionList.add(ques5)

        val ques6 = Question(
            6 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_india, "Sri Lanka" , "Chile" , "South Korea" ,
            "India", 4
        )
        QuestionList.add(ques6)

       val ques7 = Question(
            7 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_israel, "Sri Lanka" , "India" , "Israel" ,
            "Nepal", 3
        )
        QuestionList.add(ques7)

        val ques8 = Question(
            8 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_nepal, "Nepal" , "India" , "Slovakia" ,
            "France", 1
        )
        QuestionList.add(ques8)

        val ques9 = Question(
            9 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_new_zealand, "China" , "New Zealand" , "Slovakia" ,
            "Germany", 2
        )
        QuestionList.add(ques9 )

        val ques10 = Question(
            10 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_norway, "Pakistan" , "Nigeria" , "Norway" ,
            "Germany", 3
        )
        QuestionList.add(ques10 )

        val ques11 = Question(
            11 , "What country does this flag belongs to?" ,
            R.drawable.bandera_de_espana, "Bangladesh" , "Niger" , "Spain" ,
            "Peru", 3
        )
        QuestionList.add(ques11 )

        val ques12 = Question(
            12 , "What country does this flag belongs to?" ,
            R.drawable.flag_of_sri_lanka, "Sri Lanka" , "Colombia" , "Switzerland" ,
            "Netherlands", 1
        )
        QuestionList.add(ques12 )


        return QuestionList
    }
}