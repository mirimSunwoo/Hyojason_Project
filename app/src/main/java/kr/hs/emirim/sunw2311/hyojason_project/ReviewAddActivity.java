package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewAddActivity extends AppCompatActivity {
    ImageButton btnBack;
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_add);

        btnBack = findViewById(R.id.btn_review_add_back);
        btnBack.setOnClickListener(btnBackListener);

        btnConfirm = findViewById(R.id.review_add_confirm);
        btnConfirm.setOnClickListener(btnConfirmListener);
    }
    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnConfirmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"추가되었습니다.",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
