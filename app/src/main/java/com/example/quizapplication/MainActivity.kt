package com.example.quizapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapplication.ui.QuestionsActivity
import android.content.Intent
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.start_button)
        val editTextName =findViewById<EditText>(R.id.name)

        startButton.setOnClickListener{
            if(!editTextName.text.toString().isEmpty()) {
               Intent(this@MainActivity,QuestionsActivity::class.java).also {
                startActivity(it)
                finish()
                }
           }else{
               Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
            }
        }
    }
}