package com.pshetye.notificationschannelsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.NotificationManager
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    private val notificationChannels = listOf(
            Channel.DEFAULT,
            Channel.HIGH,
            Channel.MIN,
            Channel.LOW,
            Channel.NONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(getNotificationChannelFor(Channel.DEFAULT, this))
        notificationManager.createNotificationChannel(getNotificationChannelFor(Channel.HIGH, this))
        notificationManager.createNotificationChannel(getNotificationChannelFor(Channel.MIN, this))
        notificationManager.createNotificationChannel(getNotificationChannelFor(Channel.LOW, this))
        notificationManager.createNotificationChannel(getNotificationChannelFor(Channel.NONE, this))

        recyclerView = findViewById(R.id.notification_channels)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = NotificationChannelsAdapter(notificationChannels)
    }
}
