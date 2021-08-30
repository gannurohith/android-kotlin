package com.example.loginscreen

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class Register_Activity : AppCompatActivity() {
    val REQUEST_IMAGE_GALLERY = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        imageView.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("select Image")
            builder.setMessage("choose your option?")
            builder.setPositiveButton("Gallery"){
                dialog:DialogInterface,which:Int->dialog.dismiss()

                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"

                startActivityForResult(intent,REQUEST_IMAGE_GALLERY)

                }
            builder.setNegativeButton("camera"){dialog:DialogInterface,which:Int->dialog.dismiss()}

            val dialog:AlertDialog = builder.create()
            dialog.show()
            }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_IMAGE_GALLERY && resultCode == Activity.RESULT_OK && data!=null){
            imageView.setImageURI(data.data)

        }

        else{

            Toast.makeText(this,    "something went wrong",Toast.LENGTH_SHORT).show()
        }
    }
}