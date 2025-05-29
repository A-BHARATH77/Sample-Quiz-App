package com.example.quizapplication.utils

import com.example.quizapplication.model.Question
import com.example.quizapplication.R

class Constants {
    companion object {
        fun getQuestions(): MutableList<Question> {
            val questions = mutableListOf<Question>()
            val ques1 = Question(1, "What country does this flag belong to?", R.drawable.italy_flag, "Italy", "Australia", "Armenia", "India", 1)
            questions.add(ques1)
            val ques2 = Question(2, "What country does this flag belong to?", R.drawable.indian_flag, "Italy", "Australia", "Armenia", "India", 4)
            questions.add(ques2)
            val ques3 = Question(3, "What country does this flag belong to?", R.drawable.france_flag, "Italy", "Australia", "France", "India", 3)
            questions.add(ques3)
            val ques4 = Question(4, "What country does this flag belong to?", R.drawable.usa_flag, "UK", "USA", "Armenia", "India", 2)
            questions.add(ques4)
            val ques5 = Question(5, "What country does this flag belong to?", R.drawable.swiss_flag, "Swiss", "Australia", "Armenia", "India", 1)
            questions.add(ques5)
            return questions
        }
    }
}
