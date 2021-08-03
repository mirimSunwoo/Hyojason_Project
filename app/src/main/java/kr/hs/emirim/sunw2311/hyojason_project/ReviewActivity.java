package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {
    ImageButton btnReviewHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        btnReviewHome = findViewById(R.id.btn_review_home);
        btnReviewHome.setOnClickListener(btnHomeListener);
    }
    ImageButton.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    };

}
