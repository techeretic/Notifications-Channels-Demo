package com.pshetye.notificationschannelsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NotifiedActivity : AppCompatActivity() {

    companion object {
        const val KEY_RESULT = "RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notified)
        val resultView = findViewById<TextView>(R.id.result)
        resultView.text = intent.extras.getString(KEY_RESULT).toString()
    }
}
