package kr.hs.emirim.sunw2311.hyojason_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BestActivity extends AppCompatActivity {
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_food);
        setTitle("BEST FOOD");
        ImageView imgvLarge = findViewById(R.id.imgv_large);
        Gallery gallery = findViewById(R.id.gallery1);
        GalleryAdapter adapter = new GalleryAdapter(this, imgvLarge);
        gallery.setAdapter(adapter);

        btnBack = findViewById(R.id.btn_best_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}