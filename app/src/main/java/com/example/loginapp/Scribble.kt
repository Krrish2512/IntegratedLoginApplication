package com.example.loginapp

import android.graphics.Color
import android.graphics.Color.RED
import android.graphics.Paint
import android.graphics.Path
import android.hardware.camera2.params.RggbChannelVector.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.ImageButton
import android.widget.Toast
import com.example.loginapp.PaintView.Companion.colorList
import com.example.loginapp.PaintView.Companion.currentBrush
import com.example.loginapp.PaintView.Companion.pathList


class Scribble : AppCompatActivity() {
    companion object{
        var path = Path()
        var paintBrush = Paint()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scribble)
        supportActionBar?.hide()
        val redBtn = findViewById<ImageButton>(R.id.redcolor)
        val blueBtn = findViewById<ImageButton>(R.id.bluecolor)
        val blackBtn = findViewById<ImageButton>(R.id.blackcolor)
        val whiteBtn = findViewById<ImageButton>(R.id.whitecolor)
        redBtn.setOnClickListener(){
            paintBrush.setColor(Color.RED)
            currentColor(paintBrush.color)

        }
        blueBtn.setOnClickListener(){
            paintBrush.setColor(Color.BLUE)
            currentColor(paintBrush.color)

        }
        blackBtn.setOnClickListener(){
            paintBrush.setColor(Color.BLACK)
            currentColor(paintBrush.color)

        }
        whiteBtn.setOnClickListener(){
            pathList.clear()
            colorList.clear()
            path.reset()
        }




    }

    private fun currentColor(color: Int) {
        currentBrush = color
        path = Path()

    }


}