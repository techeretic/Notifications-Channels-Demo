package com.pshetye.notificationschannelsdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class NotificationChannelsAdapter(private val channels: List<Channel>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NotificationChannelViewHolder).bind(channels[position])
    }

    override fun getItemCount(): Int = channels.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            NotificationChannelViewHolder(
                    LayoutInflater
                            .from(parent.context)
                            .inflate(R.layout.notification_trigger_item, parent, false)
            )
}