package com.st10077511.historygenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private var etPersonAge: EditText? = null
    private var tvDisplay: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPersonAge  = findViewById(R.id.etAge)
        tvDisplay = findViewById(R.id.tvDisplay)

        val btnGenerateHistory = findViewById<Button>(R.id.btnGenerate)
        btnGenerateHistory.setOnClickListener{
            historygenerator()
        }
        val btnCleanerHistory = findViewById<Button>(R.id.btnClearScreen)
        btnCleanerHistory.setOnClickListener{
            clearScreen()
    }
}
    private fun historygenerator() {
        // read in the age
        // validate the age (error?)

        // find the age in the data set
        // display answer or display no answer

        var intAge: Int = 0
        var strOutput = ""

        val strEnteredValue = etPersonAge?.text.toString().trim()
        if (strEnteredValue.isEmpty()) {
            etPersonAge?.error = "Enter a number"
            return

        }
        try {
            intAge = strEnteredValue.toInt()
            if (intAge < 20 || intAge > 100) {
                //tvDisplay.text = "Error - Invalid Age"
                etPersonAge?.error = "Invalid age"
            } else {
                when (intAge) {
                    21 -> strOutput = "s21"
                    23 -> strOutput = "s23"
                    else -> {
                        strOutput = "Nothing in data set"
                    }
                }
            }
            tvDisplay?.text = strOutput
        } catch (e: NumberFormatException) {
            etPersonAge?.error = "Enter a valid Number"
        }

        /*
        if (intAge < 20 || intAge > 100){
            //tvDisplay.text = "Error - Invalid Age"
            etPersonAge?.error = "Invalid age"
        }else {
            when (intAge) {
                21 -> strOutput = "s21"
                23 -> strOutput = "s23"
            else -> {
                strOutput = "Nothing in data set"
                 }
            }
        }
        tvDisplay?.text = strOutput
         */
    }

    private fun clearScreen() {
        // clear the etPersonAge box
        // clear tvDisplay box

        etPersonAge?.text = null
        tvDisplay?.text = ""
    }
}




