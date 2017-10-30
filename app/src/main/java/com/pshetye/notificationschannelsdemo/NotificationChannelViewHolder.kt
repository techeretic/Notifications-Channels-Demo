package com.pshetye.notificationschannelsdemo

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class NotificationChannelViewHolder(private val rootView : View) : RecyclerView.ViewHolder(rootView) {
    private var channelName : TextView = itemView.findViewById(R.id.channel_name)
    private var notificationText : EditText = itemView.findViewById(R.id.channel_notification_text)
    private var notify : Button = itemView.findViewById(R.id.channel_notification_trigger)
    private var context = itemView.context

    fun bind(channel: Channel) {
        channelName.setText(channel.channelName)
        notificationText.setText(channel.dummyTestText)

        notify.setOnClickListener({
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (notificationText.text.isEmpty()) {
                Snackbar.make(rootView, R.string.error_empty_notification_text, Snackbar.LENGTH_LONG).show()
            } else {
                val mBuilder = NotificationCompat
                        .Builder(context, context.getString(channel.channelId))
                        .setSmallIcon(channel.channelNotificationIcon)
                        .setContentTitle("My notification")
                        .setContentText(notificationText.text)

                val resultIntent = Intent(context, NotifiedActivity::class.java)
                        .putExtra(NotifiedActivity.Companion.KEY_RESULT, notificationText.text.toString())
                        .putExtra(NotifiedActivity.Companion.KEY_NOTIFICATION_ID, channel.notificationId)

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