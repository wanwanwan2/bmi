package com.cookandroid.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cookandroid.bmicalculator.databinding.ActivityMainBinding
import com.cookandroid.bmicalculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 전달받은 키와 몸무게
        val height = intent.getFloatExtra("height", 0f)
        val weight = intent.getFloatExtra("weight", 0f)

        // BMI 계산
        val bmi = weight / (height / 100.0f).pow(2.0f)

        //결과 표시 5단위
        when {
            bmi >= 35 -> binding.resultTextView.text = "고도 비만"
            bmi >= 30 -> binding.resultTextView.text = "2단계 비만"
            bmi >= 25 -> binding.resultTextView.text = "1단계 비만"
            bmi >= 20 -> binding.resultTextView.text = "과체중"
            bmi >= 15 -> binding.resultTextView.text = "정상"
            else -> binding.resultTextView.text = "저체중"
        }

        when {
            bmi >= 23 ->
                binding.imageView.setImageResource(
                    R.drawable.baseline_close_24)
            bmi >= 18.5 ->
                binding.imageView.setImageResource(
                    R.drawable.baseline_fmd_bad_24)
            else ->
                binding.imageView.setImageResource(
                    R.drawable.baseline_check_circle_24)
        }

        Toast.makeText(this, "$bmi", Toast.LENGTH_SHORT).show()
    }
}