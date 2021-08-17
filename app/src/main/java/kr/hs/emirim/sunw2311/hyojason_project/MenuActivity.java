package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton btnMyPage, btnBest, btnReview, btnRecipe;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        btnMyPage = findViewById(R.id.btn_mypage);
        btnBest = findViewById(R.id.btn_menu_best);
        btnReview = findViewById(R.id.btn_menu_review);
        btnRecipe = findViewById(R.id.btn_menu_recipe);

        btnMyPage.setOnClickListener(btnListener);
        btnBest.setOnClickListener(btnBestListener);
        btnReview.setOnClickListener(btnReviewListener);
        btnRecipe.setOnClickListener(btnrecipeListener);

    }
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
}

