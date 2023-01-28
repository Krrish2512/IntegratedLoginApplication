package com.example.loginapp


import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
//import com.google.android.Image.button.ImageButton
import kotlinx.android.synthetic.main.activity_3.*


class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val Torch = findViewById<View>(R.id.Torch) as ImageButton
        val Paint = findViewById<View>(R.id.Paint) as ImageButton
        val BMI_app = findViewById<View>(R.id.BMI_app) as ImageButton
        val MessShare = findViewById<View>(R.id.MessShare) as ImageButton
        val Calc = findViewById<View>(R.id.Calc) as ImageButton
        val Tic = findViewById<View>(R.id.Tic) as ImageButton
        val Devs = findViewById<View>(R.id.Devs) as ImageButton



        Torch.setOnClickListener {
            val intent = Intent(this, Flashlight::class.java)
            startActivity(intent)
        }

        Paint.setOnClickListener {
            val intent = Intent(this, Scribble::class.java)
            startActivity(intent)
        }
        BMI_app.setOnClickListener {
            val intent = Intent(this, BMI_Calc::class.java)
            startActivity(intent)
        }
        MessShare.setOnClickListener {
            val intent = Intent(this, Message_share::class.java)
            startActivity(intent)
        }
        Calc.setOnClickListener {
            val intent = Intent(this, Calculator::class.java)
            startActivity(intent)
        }
        Tic.setOnClickListener {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }
        Devs.setOnClickListener {
            val intent = Intent(this, Developers::class.java)
            startActivity(intent)
        }
    }
}