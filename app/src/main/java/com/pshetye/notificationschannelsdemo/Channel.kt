package com.pshetye.notificationschannelsdemo

import android.app.NotificationManager
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.pshetye.notificationschannelsdemo.R

enum class Channel(
        val notificationId: Int,
        val importance: Int,
        @StringRes val channelName: Int,
        @StringRes val channelId: Int,
        @StringRes val channelDescription: Int,
        @StringRes val dummyTestText : Int,
        @StringRes val groupId: Int,
        @StringRes val groupName: Int,
        @DrawableRes val channelNotificationIcon: Int,
        @ColorInt val channelNotificationColor: Int
) {
    DEFAULT(0, NotificationManager.IMPORTANCE_DEFAULT, R.string.channel_default_importance, R.string.channel_default_importance_id, R.string.channel_default_importance_description, R.string.dummy_text_default, R.string.group_channel_default_importance_id, R.string.group_channel_default_importance, R.drawable.ic_check_black_24dp, Color.RED),
    HIGH(1, NotificationManager.IMPORTANCE_HIGH, R.string.channel_high_importance, R.string.channel_high_importance_id, R.string.channel_high_importance_description, R.string.dummy_text_high,  R.string.group_channel_default_importance_id, R.string.group_channel_default_importance, R.drawable.ic_check_black_24dp, Color.GREEN),
    MIN(2, NotificationManager.IMPORTANCE_MIN, R.string.channel_min_importance, R.string.channel_min_importance_id, R.string.channel_min_importance_description, R.string.dummy_text_min,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.BLUE),
    LOW(3, NotificationManager.IMPORTANCE_LOW, R.string.channel_low_importance, R.string.channel_low_importance_id, R.string.channel_low_importance_description, R.string.dummy_text_low,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.WHITE),
//    NONE(4, NotificationManager.IMPORTANCE_NONE, R.string.channel_none_importance, R.string.channel_none_importance_id, R.string.channel_none_importance_description, R.string.dummy_text_none,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.YELLOW),
}