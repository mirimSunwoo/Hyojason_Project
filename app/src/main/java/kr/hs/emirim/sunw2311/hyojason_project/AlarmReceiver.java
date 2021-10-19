//package kr.hs.emirim.sunw2311.hyojason_project;
//
//import android.app.Notification;
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Build;
//import android.widget.Toast;
//
//import androidx.annotation.RequiresApi;
//import androidx.core.app.NotificationCompat;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Locale;
//
//public class AlarmReceiver extends BroadcastReceiver {
//    Context context;
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
//        Intent notificationIntent = new Intent(context, TimerSettingActivity.class);
//
//        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//
//        PendingIntent pendingl = PendingIntent.getActivity(context, 0, notificationIntent, 0);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"default");
//
//        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            String channelName = "매일 알람 채널";
//            String description = "매일 정해진 시간에 알람합니다";
//            int importance = NotificationManager.IMPORTANCE_HIGH;
//
//            NotificationChannel channel = new NotificationChannel("default", channelName, importance);
//            channel.setDescription(description);
//
//            if (notificationManager != null){
//                //노티피케이션 채널을 시스템에 등록
//                notificationManager.createNotificationChannel(channel);
//            }
//        }else builder.setSmallIcon(R.mipmap.ic_launcher);
//        if (notificationManager != null) {
//            //노티피케이션 동작시킴
//            notificationManager.notify(1234, builder.build());
//
//            Calendar nextNotifyTime = Calendar.getInstance();
//
//            //내일 같은 시간으로 알람시간 결정
//            nextNotifyTime.add(Calendar.DATE,1);
//
//            // Preference에 설정한 값 저장
//            SharedPreferences.Editor editor = context.getSharedPreferences("daily alarm", Context.MODE_PRIVATE).edit();
//            editor.putLong("nextNotifyTime", nextNotifyTime.getTimeInMillis());
//            editor.apply();
//
//            Date currentDateTime = nextNotifyTime.getTime();
//            String date_text = new SimpleDateFormat("EE요일 a hh시 mm분", Locale.getDefault()).format(currentDateTime);
//            Toast.makeText(context.getApplicationContext(), "다음 알람은 " + date_text + "으로 알람이 설정", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
