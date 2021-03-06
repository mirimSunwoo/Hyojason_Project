package kr.hs.emirim.sunw2311.hyojason_project;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.BreakIterator;

public class MypageSettingActivity extends AppCompatActivity {
    ImageButton btnBack, changebtn;
    ImageView changeimg;
    TextView chlickBtn, finishBtn;
    EditText TextInputEditText_name, TextInputEditText_gender, TextInputEditText_age, TextInputEditText_intro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_setting);

        btnBack = findViewById(R.id.btn_setting_back);
        btnBack.setOnClickListener(btnBackListener);
        changeimg = findViewById(R.id.change_img);
//        changebtn = findViewById(R.id.btn_change);

        chlickBtn = findViewById(R.id.btn_change);
        finishBtn = findViewById(R.id.btn_finish);

        TextInputEditText_name = findViewById(R.id.name_input);
        TextInputEditText_gender = findViewById(R.id.gender_input);
        TextInputEditText_age = findViewById(R.id.age_input);
        TextInputEditText_intro = findViewById(R.id.intro_id);

        chlickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MypageSettingActivity.this, MypageActivity.class);
                String name = TextInputEditText_name.getText().toString();
                String gender = TextInputEditText_gender.getText().toString();
                String age = TextInputEditText_age.getText().toString();
                String intro = TextInputEditText_intro.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putString("age", age);
                bundle.putString("gender", gender);
                bundle.putString("intro", intro);

                i.putExtras(bundle);
                startActivity(i);
            }
        });


        checkSelfPermission();
        changeimg = findViewById(R.id.change_img);
        changeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //?????? ?????? ????????? ??????
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                //?????? ????????? ??????
                //intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,101);
            }
        });
    }
    //????????? ?????? ????????? ????????? ???????????? ??????
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //????????? ?????? ?????? ??????
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            int length = permissions.length;
            for (int i = 0; i < length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    // ??????
                    Log.d("MainActivity", "?????? ?????? : " + permissions[i]);
                }
            }
        }
    }
    public void checkSelfPermission() {

        String temp = "";

        //?????? ?????? ?????? ??????
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            temp += Manifest.permission.READ_EXTERNAL_STORAGE + " ";
        }

        //?????? ?????? ?????? ??????
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            temp += Manifest.permission.WRITE_EXTERNAL_STORAGE + " ";
        }


        if (TextUtils.isEmpty(temp) == false) {
            // ?????? ??????
            ActivityCompat.requestPermissions(this, temp.trim().split(" "),1);
        }else {
            // ?????? ?????? ??????
            Toast.makeText(this, "????????? ?????? ??????", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            try {
                InputStream is = getContentResolver().openInputStream(data.getData());
                Bitmap bm = BitmapFactory.decodeStream(is);
                is.close();
                changeimg.setImageBitmap(bm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (requestCode == 101 && resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "??????", Toast.LENGTH_SHORT).show();
        }
    }
    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
