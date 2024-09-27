package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val cost : Double = binding.costOfService.text.toString().toDouble()
        val theId : Int = binding.tips.checkedRadioButtonId
        val tipPercent : Double = when (theId) {
            R.id.twenty_percent -> 0.20
            R.id.eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip : Double = cost * tipPercent
        val roundUp : Boolean = binding.roundTip.isChecked
        if (roundUp) {
            tip = ceil(tip)
        }
        binding.amount.text = "Tip Amount: " + "$tip"
    }
}