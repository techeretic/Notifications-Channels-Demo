package com.pshetye.notificationschannelsdemo

import android.app.NotificationChannel
import android.content.Context
import android.support.annotation.ColorInt

fun getNotificationChannelFor(channel: Channel, context: Context) : NotificationChannel {
    return NotificationChannelBuilder(
            context.getString(channel.channelId),
            context.getString(channel.channelName),
            channel.importance
    ).setEnableLights(true)
            .setDescription(context.getString(channel.channelDescription))
            .setLightColor(channel.channelNotificationColor)
            .build()
}

private class NotificationChannelBuilder(
        private val id: String,
        private val name: String,
        private val importance: Int
) {
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
    
    fun build() : NotificationChannel {
        var channel = NotificationChannel(id, name, importance)
        channel.description = description
        channel.enableLights(enableLights)
        lightColor?.let { channel.lightColor = it }
        return channel
    }
}