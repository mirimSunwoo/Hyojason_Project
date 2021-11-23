package kr.hs.emirim.sunw2311.hyojason_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Gallery;
import android.widget.ImageView;

public class BestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_food);
        setTitle("BEST FOOD");
        ImageView imgvLarge = findViewById(R.id.imgv_large);
        Gallery gallery = findViewById(R.id.gallery1);
        GalleryAdapter adapter = new GalleryAdapter(this, imgvLarge);
        gallery.setAdapter(adapter);
    }
}