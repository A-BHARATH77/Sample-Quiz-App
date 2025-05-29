package com.example.quizapplication.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapplication.R
import com.example.quizapplication.utils.Constants
import android.widget.*
import com.example.quizapplication.model.Question
import android.graphics.Color
import android.graphics.Typeface
import androidx.core.content.ContextCompat
class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flaqImage: ImageView

    private lateinit var textViewOptionOne: TextView
    private lateinit var textViewOptionTwo: TextView
    private lateinit var textViewOptionThree: TextView
    private lateinit var textViewOptionFour: TextView
    private var currentposition = 1
    private lateinit var questionsList: MutableList<Question>
    private var selectedOptionPosition = 0
    private lateinit var checkButton: Button
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progress_bar)
        textViewProgress = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text_view)
        flaqImage = findViewById(R.id.image_flag)
        textViewOptionOne = findViewById(R.id.text_view_option_one)
        textViewOptionTwo = findViewById(R.id.text_view_option_two)
        textViewOptionThree = findViewById(R.id.text_view_option_three)
        textViewOptionFour = findViewById(R.id.text_view_option_four)
        checkButton = findViewById<Button>(R.id.button_check)

        textViewOptionOne.setOnClickListener(this)
        textViewOptionTwo.setOnClickListener(this)
        textViewOptionThree.setOnClickListener(this)
        textViewOptionFour.setOnClickListener(this)
        checkButton.setOnClickListener(this)
        questionsList = Constants.getQuestions()
        showNextQuestion()
    }

    private fun showNextQuestion() {
        resetOptions()

        currentQuestion = questionsList[currentposition - 1]

        flaqImage.setImageResource(currentQuestion.image)
        progressBar.progress = currentposition
        textViewProgress.text = "$currentposition/${progressBar.max}"
        textViewQuestion.text = currentQuestion.question
        textViewOptionOne.text = currentQuestion.optionOne
        textViewOptionTwo.text = currentQuestion.optionTwo
        textViewOptionThree.text = currentQuestion.optionThree
        textViewOptionFour.text = currentQuestion.optionFour

        if (currentposition == questionsList.size) {
            checkButton.text = "FINISH"
        } else {
            checkButton.text = "CHECK"
        }

        answered = false
    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOptionOne)
        options.add(textViewOptionTwo)
        options.add(textViewOptionThree)
        options.add(textViewOptionFour)
        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.text_view_option_one -> {
                selectedOption(textViewOptionOne, 1)
            }

            R.id.text_view_option_two -> {
                selectedOption(textViewOptionTwo, 2)
            }

            R.id.text_view_option_three -> {
                selectedOption(textViewOptionThree, 3)
            }

            R.id.text_view_option_four -> {
                selectedOption(textViewOptionFour, 4)
            }

            R.id.button_check -> {
                if (!answered) {
                    checkAnswer()
                } else {
                    currentposition++
                    showNextQuestion()
                }
            }
        }
    }

    private fun selectedOption(textView: TextView, selectOptionNumber: Int) {
        resetOptions()
        selectedOptionPosition = selectOptionNumber
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )
    }

    private fun checkAnswer() {
        answered = true
        selectedAnswer = selectedOptionPosition
        if (selectedAnswer
            == currentQuestion.correctAnswer
        ) {
            when (selectedAnswer) {
                1 -> {
                    textViewOptionOne.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.correct_option_border_bg
                        )
                }
                2 -> {
                    textViewOptionTwo.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.correct_option_border_bg
                        )
                }
                3 -> {
                    textViewOptionThree.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.correct_option_border_bg
                        )
                }
                4 -> {
                    textViewOptionFour.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.correct_option_border_bg
                        )
                }
            }
        }else{
            when (selectedAnswer) {
                1 -> {
                    textViewOptionOne.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }
                2 -> {
                    textViewOptionTwo.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }
                3 -> {
                    textViewOptionThree.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }
                4 -> {
                    textViewOptionFour.background =
                        ContextCompat.getDrawable(
                            this,
                            R.drawable.wrong_option_border_bg
                        )
                }
            }
        }
        checkButton.text = "NEXT"
        showSolution()
    }
    private fun showSolution(){
        when (currentQuestion.correctAnswer) {
            1 -> {
                textViewOptionOne.background =
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_option_border_bg
                    )
            }
            2 -> {
                textViewOptionTwo.background =
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_option_border_bg
                    )
            }
            3 -> {
                textViewOptionThree.background =
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_option_border_bg
                    )
            }
            4 -> {
                textViewOptionFour.background =
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.correct_option_border_bg
                    )
            }
        }
    }
}