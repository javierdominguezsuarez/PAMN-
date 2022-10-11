package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { resetDice() }
    }

    private fun resetDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Roll the dice"
        Toast.makeText(this, "Dice reset",Toast.LENGTH_SHORT).show()
    }

    private fun rollDice(){
        //Toast.makeText(this, "button clicked",Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()

        val resultText: TextView = findViewById(R.id.result_text)
        //resultText.text = "Dice Rolled!"
        resultText.text = randomInt.toString()

    }
}