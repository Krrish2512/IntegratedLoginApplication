package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<View>(R.id.username) as TextView
        val password = findViewById<View>(R.id.password) as TextView
        val forgotPass = findViewById<View>(R.id.forgotpass) as TextView

        val loginbtn = findViewById<View>(R.id.loginbtn) as MaterialButton

        //admin and admin


        loginbtn.setOnClickListener {
            if (username.text.toString() == "GroupX" && password.text.toString() == "Project123") {
                //correct
                val intent = Intent(this, Activity3::class.java)
                startActivity(intent)
            } else  //incorrect
                Toast.makeText(this@MainActivity, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show()
        }
        forgotPass.setOnClickListener {
            val intent = Intent(this, ForgotPassword::class.java)
            startActivity(intent)
        }

    }
    }
