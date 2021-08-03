package kr.hs.emirim.sunw2311.hyojason_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button btnJoin, btnFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar abar = getSupportActionBar();
        abar.hide();

        btnJoin = findViewById(R.id.btn_join);
        btnFind = findViewById(R.id.btn_find);

        btnJoin.setOnClickListener(btnListener);
        btnFind.setOnClickListener(btnListener1);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), FindActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
