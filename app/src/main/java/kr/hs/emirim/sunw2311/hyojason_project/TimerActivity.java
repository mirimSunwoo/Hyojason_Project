package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {
    ImageButton btnHome, btnFeed, btnSnack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        btnHome = findViewById(R.id.btn_timer_home);
        btnHome.setOnClickListener(btnHomeListener);

        btnFeed = findViewById(R.id.btn_plus_feed);
        btnSnack = findViewById(R.id.btn_plus_snack);

        btnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimerSettingActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimerSettingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
