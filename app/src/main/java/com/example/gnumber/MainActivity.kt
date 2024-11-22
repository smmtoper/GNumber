package com.example.gnumber

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minValueInput = findViewById<EditText>(R.id.minValueInput)
        val maxValueInput = findViewById<EditText>(R.id.maxValueInput)
        val startButton = findViewById<Button>(R.id.startButton)

        startButton.setOnClickListener {

            val min = minValueInput.text.toString().toIntOrNull()
            val max = maxValueInput.text.toString().toIntOrNull()


            if (min == null || max == null || min >= max) {
                Toast.makeText(this, "Диапазон неккоректен", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, GuessActivity::class.java)
            intent.putExtra("MIN_VALUE", min)
            intent.putExtra("MAX_VALUE", max)
            startActivity(intent)
        }
    }
}
