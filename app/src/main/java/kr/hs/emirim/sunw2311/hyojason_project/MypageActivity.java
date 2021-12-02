package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {
    ImageButton btnHome,btnSetting;
    Button btnLogout, btnManager;
    TextView introView, nagView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        btnHome = findViewById(R.id.btn_mypage_home);
        btnHome.setOnClickListener(btnHomeListener);

        introView = findViewById(R.id.intro_view);
        nagView = findViewById(R.id.nag_view);

        btnSetting = findViewById(R.id.btn_mypage_setting);
        btnSetting.setOnClickListener(btnSettingListener);

        btnManager = findViewById(R.id.btn_mypage_manager);
        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ManagerPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String gender = intent.getStringExtra("gender");
        String intro = intent.getStringExtra("intro");

        nagView.setText(name + "\n" + age + "\n" + gender + "\n");
        introView.setText(intro);

        btnLogout = findViewById(R.id.btn_mypage_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MypageActivity.this);
                builder.setMessage("로그아웃 하시겠습니까?");
                builder.setTitle("로그아웃 알림창")
                        .setCancelable(false)
                        .setPositiveButton("네", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("로그아웃");
                alert.show();
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
