package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            if (editTextTextEmailAddress.text == null  && editTextTextPassword.text == null) {
                Toast.makeText(this,"Please enter the value",Toast.LENGTH_SHORT).show()

            }

            else{
                Toast.makeText(this,"${editTextTextEmailAddress.text} Logged in!!",Toast.LENGTH_LONG).show()
            }
        }

        signup.setOnClickListener{
            startActivity(Intent(this,Register_Activity::class.java))
        }
    }
}