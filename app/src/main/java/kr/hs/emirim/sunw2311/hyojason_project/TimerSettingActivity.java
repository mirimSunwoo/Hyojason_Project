package kr.hs.emirim.sunw2311.hyojason_project;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TimerSettingActivity extends AppCompatActivity {
    TimePicker timePicker;
    Button check_btn;
    ImageButton set_back;
    Ringtone rt;
    PendingIntent pendingIntent;
    AlarmManager alarm_manager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_setting);

        timePicker = findViewById(R.id.tp_timepicker);
        check_btn = findViewById(R.id.btn_Check);
        set_back = findViewById(R.id.timer_setting__back);

        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final Calendar calendar = Calendar.getInstance();
        // 알람리시버 intent 생성
        final Intent my_intent = new Intent(TimerSettingActivity.this, Alarm_Receiver.class);

        check_btn.setOnClickListener(v -> {

//            calendar.setTimeInMillis(System.currentTimeMillis());
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            calendar.set(Calendar.MINUTE, minute);
            Toast.makeText(TimerSettingActivity.this,"Alarm 예정 " + hour + "시 " + minute + "분",Toast.LENGTH_SHORT).show();

            my_intent.putExtra("state","alarm on");
            pendingIntent = PendingIntent.getBroadcast(TimerSettingActivity.this, 0, my_intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            // 알람셋팅
            alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    pendingIntent);

            /*if (calendar.before(Calendar.getInstance())){
                calendar.add(Calendar.DATE, 1);
            }

            if(alarm_manager != null){
                Intent intent = new Intent(this, Alarm_Receiver.class);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarm_manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);

                Intent intent2 = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(intent2);
                finish();

                Toast.makeText(TimerSettingActivity.this,"알람이 저장되었습니다.", Toast.LENGTH_SHORT).show();
//                check_btn.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
////                        rt = RingtoneManager.getRingtone(getApplicationContext(),notification);
////                        rt.play();
////
////                    }
//                });
            }*/
        });
        set_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}