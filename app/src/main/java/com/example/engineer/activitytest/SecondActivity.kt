package com.example.engineer.activitytest

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var name:String? = intent.getStringExtra("name")
        var age:Int? = intent.getIntExtra("age", 0)
        if(name != null) {
            Log.d("SecondActivity:name", name)
            Log.d("SecondActivity:age", age.toString())
        }

    }

    fun onClick_Exit(view:View) {
        var intent = Intent()
        intent.putExtra("who", "me")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
