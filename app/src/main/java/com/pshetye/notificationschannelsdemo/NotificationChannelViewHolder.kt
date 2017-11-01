package com.pshetye.notificationschannelsdemo

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class NotificationChannelViewHolder(private val rootView : View) : RecyclerView.ViewHolder(rootView) {
    private var channelName : TextView = itemView.findViewById(R.id.channel_name)
    private var notificationText : EditText = itemView.findViewById(R.id.channel_notification_text)
    private var notify : ImageView = itemView.findViewById(R.id.channel_notification_trigger)
    private var notificationSettings : ImageView = itemView.findViewById(R.id.notification_settings)
    private var context = itemView.context

    fun bind(channel: Channel) {
        val channelId = context.getString(channel.channelId)
        channelName.setText(channel.channelName)
        notificationText.setText(channel.dummyTestText)
        notificationSettings.setOnClickListener({
            val i = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
            i.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
            i.putExtra(Settings.EXTRA_CHANNEL_ID, channelId)
            context.startActivity(i)
        })
        notify.setOnClickListener({
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (notificationText.text.isEmpty()) {
                Snackbar.make(rootView, R.string.error_empty_notification_text, Snackbar.LENGTH_LONG).show()
            } else {
                val mBuilder = NotificationCompat
                        .Builder(context, channelId)
                        .setSmallIcon(channel.channelNotificationIcon)
                        .setContentTitle("My notification")
                        .setAutoCancel(true)
                        .setContentText(notificationText.text)

                val resultIntent = Intent(context, NotifiedActivity::class.java)
                        .putExtra(NotifiedActivity.Companion.KEY_RESULT, notificationText.text.toString())

                val stackBuilder = TaskStackBuilder.create(context)
                stackBuilder.addParentStack(MainActivity::class.java)
                stackBuilder.addNextIntent(resultIntent)

                val resultPendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                )

                mBuilder.setContentIntent(resultPendingIntent)
                notificationManager.notify(channel.notificationId, mBuilder.build())
            }
        })
    }
}