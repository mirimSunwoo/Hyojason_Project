package kr.hs.emirim.sunw2311.hyojason_project;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class Alarm_Receiver extends BroadcastReceiver {
    Context context;
    String channelId = "alarm_channel";

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;
       Intent busRouteIntent = new Intent(context, TimerSettingActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntentWithParentStack(busRouteIntent);
        PendingIntent busRoutePendingIntent = stackBuilder.getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT);

        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.mipmap.ic_launcher).setDefaults(Notification.DEFAULT_ALL)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentTitle("알람")
                .setContentText("울림")
                .setContentIntent(busRoutePendingIntent);

        final NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(channelId, "Channel human readable", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
        int id = (int)System.currentTimeMillis();

        notificationManager.notify(id, notificationBuilder.build());


    }
}

