package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewAddActivity extends AppCompatActivity {
//    JoinActivity.MyDBHelper dbHelper;
    MyDBHelper dbHelper;
    SQLiteDatabase db ;
    ImageButton btnBack;
    Button btnConfirm;
    EditText Name, Info;
    private RatingBar ratingBar;
    private TextView Star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_add);

        btnBack = findViewById(R.id.btn_review_add_back);
        btnBack.setOnClickListener(btnBackListener);

        btnConfirm = findViewById(R.id.review_add_confirm);

        Name = findViewById(R.id.EditText_reviewName);
        Info = findViewById(R.id.EditText_reviewInfo);

        ratingBar = findViewById(R.id.review_ratingBar);
        Star=findViewById(R.id.review_textview);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Star.setText(""+rating);
            }
        });
        dbHelper = new MyDBHelper(this);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO reviewTB VALUES (" +
                        "'" + Name.getText().toString() + "' ,'"
                        + Info.getText().toString() + "' ,'"
                        + Star.getText().toString()  + "');");
                db.close();
                Toast.makeText(getApplicationContext(),"정상적으로 행이 삽입 되었습니다.",Toast.LENGTH_SHORT).show();
                selectDB();
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//                finish();
            }
        });
    }

    public void selectDB(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from reviewTB;", null);
        String Name = "음식이름\r\n_____________\r\n";
        String Star = "별점\r\n_____________\r\n";
        String Info = "리뷰\r\n_____________\r\n";
        while(cursor.moveToNext()){
            Name+=cursor.getString(0) + "\r\n";
            Star+=cursor.getString(1) + "\r\n";
            Info+=cursor.getString(2) + "\r\n";
        }
        cursor.close();
        db.close();
    }
    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context){
            super(context,"reviewTB",null, 3);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table reviewTB(Name char(20), Star char(20) , Info char(100));");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists reviewTB");
            onCreate(db);
        }
    }
    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ReviewActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
