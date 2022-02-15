package com.hesapmakinesiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hesapmakinesiapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var numberMemory: Int = 0//Click'leri içinde tutacak
    var firstNumber: Double = 0.0
    var secondNumber: Double = 0.0
    var numberCache: String = "0"
    var operatorCache: String = ""
    var result: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //binding, view'lere erişebiliyor.
        setBtnOnClicks()
    }

    private fun setBtnOnClicks() {
        binding.btnNumberOne.setOnClickListener {
            addNumber("1")

        }
        binding.btnNumberTwo.setOnClickListener {
            addNumber("2")
        }
        binding.btnNumberThree.setOnClickListener {
            addNumber("3")
        }
        binding.btnNumberFour.setOnClickListener {
            addNumber("4")
        }
        binding.btnNumberFive.setOnClickListener {
            addNumber("5")
        }
        binding.btnNumberSix.setOnClickListener {
            addNumber("6")
        }
        binding.btnNumberSeven.setOnClickListener {
            addNumber("7")
        }
        binding.btnNumberEight.setOnClickListener {
            addNumber("8")
        }
        binding.btnNumberNine.setOnClickListener {
            addNumber("9")
        }
        binding.btnZero.setOnClickListener {
            addNumber("0")
        }
        /////////////////////////////////////////////////////////
        binding.btnPlus.setOnClickListener {
            sum()
        }
        binding.btnMinus.setOnClickListener {
            extraction()
        }
        binding.btnMultiply.setOnClickListener {
            multiply()
        }
        binding.btnDivide.setOnClickListener {
            divide()
        }
        binding.btnClear.setOnClickListener {
            binding.tvEnterNumber.text = ""
            binding.tvResult.text = ""

        }
        binding.btnDel.setOnClickListener {
            //son basamağı sildirmek için
            var text: String = binding.tvEnterNumber.text.toString()
            if (text.isNotEmpty()) {
                text = text.substring(0, text.length - 1)
                binding.tvEnterNumber.text = text
            }




            binding.tvResult.text = ""
            clearAllCache()
        }
        binding.btnEquals.setOnClickListener {
            if (firstNumber != 0.0 && !numberCache.isNullOrBlank()) {
                secondNumber = numberCache.toDouble()
                result = when (operatorCache) {
                    "+" -> firstNumber + secondNumber
                    "-" -> firstNumber - secondNumber
                    "*" -> firstNumber * secondNumber
                    "/" -> firstNumber / secondNumber
                    else -> 0.0
                }
                binding.tvResult.text = result.toString()
                clearAllCache()
            }
        }

    }

    private fun clearAllCache() {
        operatorCache = ""
        numberCache = ""
        result = 0.0
        firstNumber = 0.0
        secondNumber = 0.0
    }

    private fun addNumber(s: String) {
        if (s == "1" || s == "2" || s == "3" || s == "4" || s == "5" || s == "6" || s == "7" || s == "8" || s == "9" || s == "0") {
            val newNumber = binding.tvEnterNumber.text.toString() + s
            binding.tvEnterNumber.text = newNumber
            numberCache += s
        }
    }

    private fun sum() {//Toplama
        onCallOperator("+")
    }

    private fun extraction() {//Çıkartma
        onCallOperator("-")
    }

    private fun multiply() {
        onCallOperator("*")
    }

    private fun divide() {
        onCallOperator("/")
    }

    private fun onCallOperator(operator: String) {
        if (!numberCache.isNullOrBlank()) {
            val newProcess = binding.tvEnterNumber.text.toString() + operator
            binding.tvEnterNumber.text = newProcess
            firstNumber = numberCache.toDouble()
            numberCache = ""
            operatorCache = operator
        }
    }
}








