package ru.myitschool.lab23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.myitschool.lab23.databinding.ActivityMainBinding
import kotlin.math.ln

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.content.getRandomNums.setOnClickListener {getRandomValue()}
    }

    private fun getRandomValue() {
        val sizeText = binding.content.sizeParam.text.toString()
        val shapeText = binding.content.shapeParam.text.toString()
        val rateText = binding.content.rateParam.text.toString()

        val n = if (sizeText == "") 0 else sizeText.toInt()
        val k = if (shapeText == "") 0 else shapeText.toInt()
        val r = if (rateText == "") 0.0 else rateText.toDouble()

        val calcArray = DoubleArray(n)
        repeat(n) {
            calcArray[it] = calcLog(k, r)
        }

        val intent = Intent(this, ShowActivity::class.java)
        intent.putExtra("myArray", calcArray)
        startActivity(intent)
    }

    private fun calcLog(kNum: Int, rNum: Double): Double {
        var result = 0.0
        repeat(kNum) {
            val random = Math.random()
            result += ln(random)
        }
        return -result / rNum
    }
}