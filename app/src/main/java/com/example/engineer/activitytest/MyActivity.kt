package com.example.engineer.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.util.Log

class MyActivity : AppCompatActivity() {
    private var editText:EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_activity)
        editText = findViewById(R.id.editText)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //super.onActivityResult(requestCode, resultCode, data)
        Log.d("onActivityResult:", requestCode.toString())
        when(requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    var returnData = data?.getStringExtra("who")
                    Log.d("MyActivity", returnData)
                }
            }
        }
    }
    fun onClick(view: View) {
        editText?.setText("hello World!!")
    }
    fun onClick_Toast(view:View) {
        Toast.makeText(this, editText?.text, Toast.LENGTH_LONG).show()
    }
    fun onClick_Exit(view:View) {
        finish()
    }

    fun onClick_ShowSecondActivity(view:View) {
        var intent = Intent("com.example.engineer.activity.SECOND_ACTIVITY")
        intent.putExtra("name","Mary")
        intent.putExtra("age", 24)
        startActivityForResult(intent, 1)
    }
    fun onClick_ShowWeb(view:View) {
        var intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse("https://google.com"))
        startActivity(intent)
    }
}