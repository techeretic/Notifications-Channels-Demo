package com.pshetye.notificationschannelsdemo

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.support.design.widget.Snackbar
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationCompat.GROUP_ALERT_ALL
import android.support.v4.app.NotificationCompat.GROUP_ALERT_SUMMARY
import android.support.v4.app.NotificationManagerCompat.IMPORTANCE_DEFAULT
import android.support.v4.app.NotificationManagerCompat.IMPORTANCE_HIGH
import android.support.v4.app.TaskStackBuilder
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class NotificationChannelViewHolder(private val rootView : View) : RecyclerView.ViewHolder(rootView) {

    private var channelName : TextView = itemView.findViewById(R.id.channel_name)
    private var notificationText : EditText = itemView.findViewById(R.id.channel_notification_text)
    private var notify : ImageView = itemView.findViewById(R.id.channel_notification_trigger)
    private var notificationSettings : ImageView = itemView.findViewById(R.id.notification_settings)
    private var context = itemView.context
    private var counter = 0

    fun bind(channel: Channel) {
        val channelId = context.getString(channel.channelId)
        val oddInboxStyle = NotificationCompat.InboxStyle()
        val evenInboxStyle = NotificationCompat.InboxStyle()
        val lowImportanceInboxStyle = NotificationCompat.InboxStyle()
        channelName.setText(channel.channelName)
        notificationText.setText(channel.dummyTestText)
        notificationSettings.setOnClickListener({
            val i = Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS)
            i.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
            i.putExtra(Settings.EXTRA_CHANNEL_ID, channelId)
            context.startActivity(i)
        })

        val builder = NotificationCompat
                .Builder(context, channelId)
                .setSmallIcon(channel.channelNotificationIcon)
                .setAutoCancel(true)

        var intentText = ""

        val evenName = "Page-Notifications-Group-0"
        val oddName = "Page-Notifications-Group-1"

        notify.setOnClickListener({
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (notificationText.text.isEmpty()) {
                Snackbar.make(rootView, R.string.error_empty_notification_text, Snackbar.LENGTH_LONG).show()
            } else {
                val notificationContent = "${notificationText.text} - line $counter"
                intentText += "\n$notificationContent"

                var notificationID = channel.notificationId
                if (channel.importance == IMPORTANCE_DEFAULT ||
                        channel.importance == IMPORTANCE_HIGH) {
                    builder.setGroupAlertBehavior(if (counter < 2) GROUP_ALERT_ALL else GROUP_ALERT_SUMMARY)
                    if (counter.rem(2) == 0) {
                        builder.setGroup(evenName)
                                .setContentTitle(channel.name)

                        evenInboxStyle.setBigContentTitle(channel.name)
                        evenInboxStyle.addLine(notificationContent)
                        builder.setStyle(evenInboxStyle).setNumber(++counter)
                    } else {
                        notificationID = channel.notificationId*10

                        builder.setGroup(oddName)
                                .setContentTitle(channel.name)

                        oddInboxStyle.setBigContentTitle(channel.name)
                        oddInboxStyle.addLine(notificationContent)
                        builder.setStyle(oddInboxStyle).setNumber(++counter)
                    }
                } else {
                    lowImportanceInboxStyle.setBigContentTitle(channel.name)
                    lowImportanceInboxStyle.addLine(notificationContent)
                    builder.setContentTitle(channel.name)
                            .setStyle(lowImportanceInboxStyle).setNumber(++counter)
                }

                val resultIntent = Intent(context, NotifiedActivity::class.java)
                        .putExtra(NotifiedActivity.Companion.KEY_RESULT, intentText)

                val stackBuilder = TaskStackBuilder.create(context)
                stackBuilder.addParentStack(MainActivity::class.java)
                stackBuilder.addNextIntent(resultIntent)

                val resultPendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                )

                builder.setContentIntent(resultPendingIntent)

                notificationManager.notify(notificationID, builder.build())
            }
        })
    }
}