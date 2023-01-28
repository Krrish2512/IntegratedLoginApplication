package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_message_share.*

class Message_share : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_share)

        btnEnter.setOnClickListener {
            val message: String = etUserMsg.text.toString()
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

        btnShareToOtherApp.setOnClickListener(){

            val message: String = etUserMsg.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to :" ))

        }

    }
}