package com.example.amirdin_hw5_2m

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    var result: TextView? = null
    var firstNumber: Int? = null
    var secondNumber: Int? = null
    var isOperation: Boolean = false
    var currentOperation: String? = null
    var currentText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById<TextView>(R.id.result)
    }

    fun numberClick(view: View?) {
        if (view is MaterialButton) {
            val text = view.text.toString()
            if (isOperation) {
                result!!.text = ""
            }
            result!!.append(text)
        }
        isOperation = false
    }

    fun operationClick(view: View) {
        if (view.id == R.id.clearBtn) {
            result!!.text = ""
        } else if (view.id == R.id.plusBtn) {
            firstNumber = result!!.text.toString().toInt()
            currentOperation = "+"
        } else if (view.id == R.id.minusBtn) {
            firstNumber = result!!.text.toString().toInt()
            currentOperation = "-"
        } else if (view.id == R.id.multiplyBtn) {
            firstNumber = result!!.text.toString().toInt()
            currentOperation = "*"
        } else if (view.id == R.id.divideBtn) {
            firstNumber = result!!.text.toString().toInt()
            currentOperation = "/"
        } else if (view.id == R.id.equalBtn) {
            secondNumber = result!!.text.toString().toInt()

            if (currentOperation === ("+")) {
                val resultPlus = firstNumber!! + secondNumber!!
                result!!.text = resultPlus.toString()
            } else if (currentOperation === ("-")) {
                val resultMinus = firstNumber!! - secondNumber!!
                result!!.text = resultMinus.toString()
            } else if (currentOperation === ("*")) {
                val resultMultiply = firstNumber!! * secondNumber!!
                result!!.text = resultMultiply.toString()
            } else if (currentOperation === ("/")) {
                val resultDivine = firstNumber!! / secondNumber!!
                result!!.text = resultDivine.toString()
            }
        }
        isOperation = true
    }
}