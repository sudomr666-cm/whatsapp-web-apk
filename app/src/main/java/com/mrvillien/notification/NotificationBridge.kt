package com.mrvillien.notification

import android.app.*
import android.content.Context
import androidx.core.app.NotificationCompat

object NotificationBridge {

    fun push(context: Context, title: String, msg: String) {
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val ch = NotificationChannel("web","Web",NotificationManager.IMPORTANCE_HIGH)
        manager.createNotificationChannel(ch)

        val n = NotificationCompat.Builder(context,"web")
            .setContentTitle(title)
            .setContentText(msg)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .build()

        manager.notify(1,n)
    }
}
