package kr.hs.emirim.sunw2311.hyojason_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button btnJoin;
    TextView textFind, textLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar abar = getSupportActionBar();
        abar.hide();

        btnJoin = findViewById(R.id.btn_join);
        textFind = findViewById(R.id.text_find);
        textLogin = findViewById(R.id.text_login);

        btnJoin.setOnClickListener(btnListener);
        textFind.setOnClickListener(btnListener1);
        textLogin.setOnClickListener(btnMenuListener);
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
    View.OnClickListener btnMenuListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
