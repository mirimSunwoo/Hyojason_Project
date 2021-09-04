package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class FindActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id_pass);

        ActionBar abar = getSupportActionBar();
        abar.hide();

        TextView textCheck1, textCheck2;
        ImageButton BackButton;

        textCheck1 = findViewById(R.id.text_check1);
        textCheck2 = findViewById(R.id.text_check2);
        BackButton = findViewById(R.id.btn_find_back);

        textCheck1.setOnClickListener(btnListener);
        textCheck2.setOnClickListener(btnListener);
        BackButton.setOnClickListener(btnBackListener);

    }
    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
