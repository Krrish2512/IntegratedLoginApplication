package com.example.loginapp

//import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException


class Calculator : AppCompatActivity() {

    var lastnumeric = false
    var lastdot = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

//        val mTextView = findViewById<TextView>(R.id.made_by)
//        mTextView.movementMethod = LinkMovementMethod.getInstance()
        val mTextView2 = findViewById<TextView>(R.id.made_byy)
        mTextView2.movementMethod = LinkMovementMethod.getInstance()
    }



    fun onDigit(view: View){
        tvInput.append((view as Button).text)
        lastnumeric = true

    }
    fun onClear(view: View){
        tvInput.text=" "
        lastdot=false
        lastnumeric=false
    }
    fun ondecimalpoint(view: View){
        if (lastnumeric && !lastdot){
            tvInput.append(".")
            lastnumeric=false
            lastdot=true }
    }

    private fun removezeroafterdot(result: String) :String{
        var value = result
        if (result.contains(".0"))
            value = result.substring(0, result.length - 2)
        return value
    }

    fun onOperator(view: View){
        if (lastnumeric && !isOperatorAdded(tvInput.text.toString())){
            tvInput.append((view as Button).text)
            lastnumeric=false
            lastdot=false
        }
    }

    fun onEqual(view:View){
        if (lastnumeric){
            var tvValue = tvInput.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")){
                    prefix="-"
                    tvValue = tvValue.substring(1)
                }

                if (tvValue.contains("-")){
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    tvInput.text = removezeroafterdot((one.toDouble() - two.toDouble()).toString())
                }else if (tvValue.contains("/")){
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    tvInput.text = removezeroafterdot((one.toDouble() / two.toDouble()).toString())
                }else if (tvValue.contains("+")){
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    tvInput.text = removezeroafterdot((one.toDouble() + two.toDouble()).toString())
                }else if (tvValue.contains("*")){
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]

                    if (!prefix.isEmpty()){
                        one=prefix+one
                    }

                    tvInput.text = removezeroafterdot((one.toDouble() * two.toDouble()).toString())
                }
            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean{
        return if (value.startsWith("-")){
            false
        }else{
            value.contains("/")||value.contains("*")
                    ||value.contains("+")||value.contains("-")
        }
    }


}