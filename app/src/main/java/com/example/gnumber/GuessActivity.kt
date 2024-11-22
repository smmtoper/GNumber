package com.example.gnumber

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GuessActivity : AppCompatActivity() {

    private var min = 0
    private var max = 0
    private var currentGuess = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)

        min = intent.getIntExtra("MIN_VALUE", -1)
        max = intent.getIntExtra("MAX_VALUE", -1)
        if (min == -1 || max == -1 || min >= max) {
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val questionText = findViewById<TextView>(R.id.questionText)
        val greaterButton = findViewById<Button>(R.id.greaterButton)
        val lessButton = findViewById<Button>(R.id.lessButton)
        val correctButton = findViewById<Button>(R.id.correctButton)

        updateGuess()

        greaterButton.setOnClickListener {
            min = currentGuess + 1
            updateGuess()
        }

        lessButton.setOnClickListener {
            max = currentGuess - 1
            updateGuess()
        }

        correctButton.setOnClickListener {
            Toast.makeText(this, "Угадал. Ваше число $currentGuess", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun updateGuess() {
        if (min > max) {
            Toast.makeText(this, "Невозможно угадать число", Toast.LENGTH_LONG).show()
            finish()
            return
        }
        currentGuess = (max - min) / 2 + min
        findViewById<TextView>(R.id.questionText).text = "Ваше число $currentGuess?"
    }
}
