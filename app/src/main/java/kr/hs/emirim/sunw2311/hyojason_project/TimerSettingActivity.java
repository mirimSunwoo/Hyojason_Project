package kr.hs.emirim.sunw2311.hyojason_project;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
    Intent intent2;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_setting);

        timePicker = findViewById(R.id.tp_timepicker);
        check_btn = findViewById(R.id.btn_Check);

        check_btn.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            calendar.get(Calendar.HOUR_OF_DAY);
            calendar.set(Calendar.MINUTE, minute);

            if (calendar.before(Calendar.getInstance())){
                calendar.add(Calendar.DATE, 1);
            }
            AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
            if(alarmManager != null){
                Intent intent = new Intent(this, Alarm_Receiver.class);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);

                Intent intent2 = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(intent2);
                finish();

                Toast.makeText(TimerSettingActivity.this,"알람이 저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}