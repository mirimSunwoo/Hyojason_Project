package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeActivity extends AppCompatActivity {
    ImageButton btnRecipeHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_food);

        btnRecipeHome = findViewById(R.id.btn_recipe_home);
        btnRecipeHome.setOnClickListener(btnHomeListener);

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

