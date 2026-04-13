package com.serge.medlife.notifications

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build

fun scheduleNotificationReminder(
    context: Context,
    medName: String,
    dosage: String,
    timeInMillis: Long,
    notificationId: Int
) {
    val intent = Intent(context, NotificationReceiver::class.java).apply {
        putExtra("title","Medication Reminder")
        putExtra("message", "Time to take $dosage of $medName")
    }

    val pendingIntent = PendingIntent.getBroadcast(
        context,
        notificationId,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val alarmManager = context.getSystemService(AlarmManager::class.java)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        if (alarmManager.canScheduleExactAlarms()) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                timeInMillis,
                pendingIntent
            )
        }
        else {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                timeInMillis,
                pendingIntent
            )
        }
    }
}

fun cancelNotification(context: Context, notificationId: Int) {
    val intent = Intent(context, NotificationReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        context,
        notificationId,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )
    val alarmManager = context.getSystemService(AlarmManager::class.java)
    alarmManager.cancel(pendingIntent)
}