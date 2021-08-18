package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class RecipeActivity extends AppCompatActivity {
    ImageButton btnRecipeHome,btnSamgyetang;
    TextView textSamgyetang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_food);

        btnRecipeHome =  findViewById(R.id.btn_recipe_home);
        btnRecipeHome.setOnClickListener(btnHomeListener);

        textSamgyetang = findViewById(R.id.text_samgyetang);
        textSamgyetang.setOnClickListener(textListener);

        btnSamgyetang = findViewById(R.id.btn_samgyetang);
        btnSamgyetang.setOnClickListener(btnSamgyetangListener);

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
            Intent intent = new Intent(getApplicationContext(), RecipeExActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnSamgyetangListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), RecipeExActivity.class);
            startActivity(intent);
            finish();
        }
    };
}

