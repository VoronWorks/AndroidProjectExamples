package com.example.app1_352_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val btn: Button =findViewById(R.id.btnCalculate)
    btn.setOnClickListener {
        val num2=findViewById<EditText>(R.id.edtNumber2)
        var n2: Float? = null
        try {
            n2 = num2.text.toString().toFloat()
        }catch (nfe:NumberFormatException){
            num2.error = "Введите число"
            num2.requestFocus()
        }
        val et0p=findViewById<EditText>(R.id.etOperation)
        var oper: String = et0p.text.toString()
        if(oper.isBlank() or (oper.length>1) or (!("+=*/".contains(oper)))) {
            et0p.error = "Укажите верную операцию"
            et0p.requestFocus()
            oper = ""
        }
        val num1=findViewById<EditText>(R.id.edtNumber1)
        var n1: Float? = null
        try {
            n1 = num1.text.toString().toFloat()
        }catch (nfe:NumberFormatException){
            num1.error = "Введите число"
            num1.requestFocus()
        }
        if ((n1==null) or(n2==null) or oper.isBlank()) return@setOnClickListener

        findViewById<TextView>(R.id.tvResult).text=when(oper){
            "*"->{
                (n1!! * n2!!).toString()
            }
            "/"->{
                (n1!! / n2!!).toString()
            }
            "+"->{
                (n1!! + n2!!).toString()
            }
            "-"->{
                (n1!! - n2!!).toString()
            }
            else->""
        }
    }
    }


}