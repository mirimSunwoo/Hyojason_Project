package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton btnMyPage, btnBest, btnReview, btnRecipe, btnTimer;
        EditText btnSearch;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnSearch = findViewById(R.id.btn_menu_search);
        btnMyPage = findViewById(R.id.btn_mypage);
        btnBest = findViewById(R.id.btn_menu_best);
        btnReview = findViewById(R.id.btn_menu_review);
        btnRecipe = findViewById(R.id.btn_menu_recipe);
        btnTimer = findViewById(R.id.btn_menu_timer);
        btnSearch = findViewById(R.id.btn_menu_search);

        btnSearch.setOnClickListener(btnSearchListener);
        btnMyPage.setOnClickListener(btnListener);
        btnBest.setOnClickListener(btnBestListener);
        btnReview.setOnClickListener(btnReviewListener);
        btnRecipe.setOnClickListener(btnrecipeListener);
        btnTimer.setOnClickListener(btnTimerListener);
        btnSearch.setOnClickListener(btnSearchListener);

    }
    View.OnClickListener btnSearchListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
            finish();
        }
    };
    ImageButton.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnBestListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), BestActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnReviewListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnrecipeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnTimerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
            startActivity(intent);
            finish();
        }
    };
}

