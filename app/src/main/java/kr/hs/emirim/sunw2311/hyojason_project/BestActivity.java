package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BestActivity extends AppCompatActivity {
    ImageButton btnBestHome;
    TextView TextPaprika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_food);

        btnBestHome = findViewById(R.id.btn_best_home);
        btnBestHome.setOnClickListener(btnHomeListener);
        TextPaprika = findViewById(R.id.text_paprika);
        TextPaprika.setOnClickListener(textListener);
    }
    ImageButton.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener textListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), BestExActivity.class);
            startActivity(intent);
            finish();
        }
    };
}