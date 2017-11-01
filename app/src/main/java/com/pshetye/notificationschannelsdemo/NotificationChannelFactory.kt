package com.pshetye.notificationschannelsdemo

import android.app.NotificationChannel
import android.content.Context
import android.support.annotation.ColorInt

fun getNotificationChannelFor(channel: Channel, context: Context) : NotificationChannel =
        NotificationChannelBuilder(context.getString(channel.channelId), context.getString(channel.channelName), channel.importance)
                .setEnableLights(true)
                .setDescription(context.getString(channel.channelDescription))
                .setLightColor(channel.channelNotificationColor)
                .setGroupId(context.getString(channel.groupId))
                .build()

private class NotificationChannelBuilder(
        private val id: String,
        private val name: String,
        private val importance: Int
) {
    private var groupId: String? = null
    private var description: String? = null
    private var enableLights: Boolean = false
    @ColorInt private var lightColor: Int? = null
    
    fun setDescription(description: String) : NotificationChannelBuilder {
        this.description = description
        return this
    }
    
    fun setEnableLights(enableLights: Boolean) : NotificationChannelBuilder {
        this.enableLights = enableLights
        return this
    }

    fun setLightColor(@ColorInt lightColor: Int) : NotificationChannelBuilder {
        this.lightColor = lightColor
        return this
    }

    fun setGroupId(groupId: String) : NotificationChannelBuilder {
        this.groupId = groupId
        return this
    }
    
    fun build() : NotificationChannel {
        val channel = NotificationChannel(id, name, importance)
        channel.description = description
        channel.enableLights(enableLights)
        groupId?.let { channel.group = it }
        lightColor?.let { channel.lightColor = it }
        return channel
    }
}