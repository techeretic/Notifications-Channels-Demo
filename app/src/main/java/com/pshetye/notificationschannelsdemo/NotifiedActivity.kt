package com.pshetye.notificationschannelsdemo

import android.app.NotificationManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NotifiedActivity : AppCompatActivity() {

    companion object {
        const val KEY_RESULT = "RESULT"
        const val KEY_NOTIFICATION_ID = "NOTIFICATION_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notified)
        val resultView = findViewById<TextView>(R.id.result)
        resultView.text = intent.extras.getString(KEY_RESULT).toString()
        val notificationId = intent.extras.getInt(KEY_NOTIFICATION_ID)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(notificationId)
    }
}
