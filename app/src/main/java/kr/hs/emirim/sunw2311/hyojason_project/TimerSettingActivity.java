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
    Context context;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_setting);

        btn_back = findViewById(R.id.timer_setting__back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        this.context = this;

        //알람매니저 설정
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //타임피커 설정
        timePicker = findViewById(R.id.tp_timepicker);

        // Calendar 객체 생성
        final Calendar calendar = Calendar.getInstance();

        //알람리시버 intent 생성
        final Intent my_intent = new Intent(this.context, Alarm_Receiver.class);

        // 알람 시작 버튼
        Button alarm_on = findViewById(R.id.btn_Check);
        alarm_on.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    // calendar에 시간 셋팅
                    calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                    calendar.set(Calendar.MINUTE, timePicker.getMinute());

                    //시간 가져옴
                    int hour = timePicker.getHour();
                    int minute = timePicker.getMinute();
                    Toast.makeText(TimerSettingActivity.this,"hour + 시 " + minute + "분" + " 알람 예정", Toast.LENGTH_SHORT);

                    // reveiver에 string값 넘겨주기
                    my_intent.putExtra("state", "alarm on");

                    pendingIntent = PendingIntent.getBroadcast(TimerSettingActivity.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    //알람 셋팅
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }
        });

    }
}
