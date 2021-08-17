package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {
    ImageButton btnHome,btnSetting;
    Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btnHome = findViewById(R.id.btn_mypage_home);
        btnHome.setOnClickListener(btnHomeListener);

        btnSetting = findViewById(R.id.btn_mypage_setting);
        btnSetting.setOnClickListener(btnSettingListener);

        btnLogout = findViewById(R.id.btn_mypage_logout);
        btnLogout.setOnClickListener(btnLogoutListener);
    }
    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnSettingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MypageSettingActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnLogoutListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
