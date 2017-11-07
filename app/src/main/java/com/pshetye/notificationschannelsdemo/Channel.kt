package com.pshetye.notificationschannelsdemo

import android.app.NotificationManager
import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

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
    HIGH(1, NotificationManager.IMPORTANCE_HIGH, R.string.channel_high_importance, R.string.channel_high_importance_id, R.string.channel_high_importance_description, R.string.dummy_text_high,  R.string.group_channel_default_importance_id, R.string.group_channel_default_importance, R.drawable.ic_check_black_24dp, Color.GREEN),
    MIN(2, NotificationManager.IMPORTANCE_MIN, R.string.channel_min_importance, R.string.channel_min_importance_id, R.string.channel_min_importance_description, R.string.dummy_text_min,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.BLUE),
    LOW1(3, NotificationManager.IMPORTANCE_LOW, R.string.channel_low_importance_1, R.string.channel_low_importance_id_1, R.string.channel_low_importance_description_1, R.string.dummy_text_low_1,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.WHITE),
    LOW2(4, NotificationManager.IMPORTANCE_LOW, R.string.channel_low_importance_2, R.string.channel_low_importance_id_2, R.string.channel_low_importance_description_2, R.string.dummy_text_low_2,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.WHITE),
    LOW3(5, NotificationManager.IMPORTANCE_LOW, R.string.channel_low_importance_3, R.string.channel_low_importance_id_3, R.string.channel_low_importance_description_3, R.string.dummy_text_low_3,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.WHITE),
    DEFAULT1(6, NotificationManager.IMPORTANCE_DEFAULT, R.string.channel_default_importance_1, R.string.channel_default_importance_id_1, R.string.channel_default_importance_description_1, R.string.dummy_text_default_1, R.string.group_channel_default_importance_id, R.string.group_channel_default_importance, R.drawable.ic_check_black_24dp, Color.RED),
    DEFAULT2(7, NotificationManager.IMPORTANCE_DEFAULT, R.string.channel_default_importance_2, R.string.channel_default_importance_id_2, R.string.channel_default_importance_description_2, R.string.dummy_text_default_2, R.string.group_channel_default_importance_id, R.string.group_channel_default_importance, R.drawable.ic_check_black_24dp, Color.RED),
    DEFAULT3(8, NotificationManager.IMPORTANCE_DEFAULT, R.string.channel_default_importance_3, R.string.channel_default_importance_id_3, R.string.channel_default_importance_description_3, R.string.dummy_text_default_3, R.string.group_channel_default_importance_id, R.string.group_channel_default_importance, R.drawable.ic_check_black_24dp, Color.RED),
    DEFAULT4(9, NotificationManager.IMPORTANCE_DEFAULT, R.string.channel_default_importance_4, R.string.channel_default_importance_id_4, R.string.channel_default_importance_description_4, R.string.dummy_text_default_4, R.string.group_channel_default_importance_id, R.string.group_channel_default_importance, R.drawable.ic_check_black_24dp, Color.RED);
//    NONE(4, NotificationManager.IMPORTANCE_NONE, R.string.channel_none_importance, R.string.channel_none_importance_id, R.string.channel_none_importance_description, R.string.dummy_text_none,  R.string.group_channel_low_importance_id, R.string.group_channel_low_importance, R.drawable.ic_check_black_24dp, Color.YELLOW),
}