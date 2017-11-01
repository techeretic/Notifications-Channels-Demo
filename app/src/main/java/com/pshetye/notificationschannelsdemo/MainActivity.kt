package com.pshetye.notificationschannelsdemo

import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    private val notificationChannels = mutableListOf<Channel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val defaultImportanceGroup = NotificationChannelGroup(
                getString(R.string.group_channel_default_importance_id),
                getString(R.string.group_channel_default_importance)
        )
        val lowImportanceGroup = NotificationChannelGroup(
                getString(R.string.group_channel_low_importance_id),
                getString(R.string.group_channel_low_importance)
        )

        notificationManager.createNotificationChannelGroups(listOf(defaultImportanceGroup, lowImportanceGroup))

        for (channel in Channel.values()) {
            notificationChannels.add(channel)
            notificationManager.createNotificationChannel(getNotificationChannelFor(channel, this))
        }

        recyclerView = findViewById(R.id.notification_channels)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = NotificationChannelsAdapter(notificationChannels)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.notification_settings_menu) {
            val i = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
            i.putExtra(Settings.EXTRA_APP_PACKAGE, packageName)
            startActivity(i)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
