package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
        binding.errorText.visibility = View.INVISIBLE
    }

    private fun calculateTip() {
        val stringInTextField = binding.costService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if(cost == null) {
            binding.tipAmount.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.eighteen_percent_option -> 0.18
            R.id.twenty_percent_option -> 0.20
            R.id.fifteen_percent_option -> 0.15
            else -> 0.0
        }
        if(tipPercentage == 0.0) {
            binding.errorText.visibility = View.VISIBLE
        } else {
            var tip = tipPercentage * cost
            if (binding.roundUpSwitch.isChecked) {
                tip = kotlin.math.ceil(tip)
            }
            val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
            binding.tipAmount.text = getString(R.string.tip_amount, formattedTip)
            binding.errorText.visibility = View.INVISIBLE
            binding.tipAmount.visibility = View.VISIBLE
        }
    }
}