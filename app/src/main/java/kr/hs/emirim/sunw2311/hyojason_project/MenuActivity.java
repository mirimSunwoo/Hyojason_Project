package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton btnBest, btnReview, btnRecipe, btnTimer;
        ImageButton btnRecipeHome, btnReviewHome, btnBestHome, btnTimerHome, btnSearchHome;
        EditText btnSearch;


        btnSearch = findViewById(R.id.btn_menu_search);
        btnBest = findViewById(R.id.btn_menu_best);
        btnRecipe = findViewById(R.id.btn_menu_recipe);
        btnReview = findViewById(R.id.btn_menu_review);
        btnTimer = findViewById(R.id.btn_menu_timer);

//        btnRecipeHome = findViewById(R.id.btn_recipe_home);
//        btnReviewHome = findViewById(R.id.btn_review_home);
//        btnBestHome = findViewById(R.id.btn_best_home);
//        btnSearchHome = findViewById(R.id.btn_search_home);
//        btnTimerHome = findViewById(R.id.btn_timer_home);
//
//        btnRecipeHome.setOnClickListener(btnHomeListener);
//        btnReviewHome.setOnClickListener(btnHomeListener);
//        btnBestHome.setOnClickListener(btnHomeListener);
//        btnSearchHome.setOnClickListener(btnHomeListener);
//        btnTimerHome.setOnClickListener(btnHomeListener);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnBest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BestActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecipeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(intent);
                finish();
            }
        });
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

