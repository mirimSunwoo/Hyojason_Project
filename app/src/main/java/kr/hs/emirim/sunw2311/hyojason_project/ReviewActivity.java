package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class ReviewActivity extends AppCompatActivity {
    ImageButton btnHome, btnReviewAdd;
    ListView list;
    ReviewAddActivity.MyDBHelper dbHelper;
    ArrayList<HashMap<String,String>> arrData;
    TextView editAllResult;

//    private  static final String TAG_NAME = "name";
//    private  static final String TAG_STAR = "star";
//    private static final String TAG_INFO = "info";

    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        btnHome = findViewById(R.id.btn_review_home);
        btnHome.setOnClickListener(btnHomeListener);

        btnReviewAdd = findViewById(R.id.btn_review_add);
        btnReviewAdd.setOnClickListener(btnReviewAddListener);

        editAllResult = findViewById(R.id.review_all);
//        editAllResult.setEnabled(false);
        editAllResult.setMovementMethod(new ScrollingMovementMethod());

        setData();

//        list= (ListView)findViewById(R.id.reivew_listview);
        arrData = new ArrayList<HashMap<String,String>>();
        dbHelper = new ReviewAddActivity.MyDBHelper(this);
        showList();
    }

    private void setData(){
//        arrData = new ArrayList<MyReviewData>();
//        arrData.add(new MyReviewData("살코기", "맛없어", "Rating"));
//        arrData.add(new MyReviewData(R.drawable.ic_launcher, "쥬얼리", "010-3333-4444", "juerly@daum.net"));
//        arrData.add(new MyReviewData(R.drawable.ic_launcher, "시크릿", "010-5555-6666", "secret@paran.com"));
    }
    View.OnClickListener btnHomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            finish();
        }
    };
    View.OnClickListener btnReviewAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ReviewAddActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        showList();
    }

    protected void showList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
//            SQLiteDatabase db = this.openOrCreateDatabase(ReviewAddActivity.reviewTB, MODE_PRIVATE, null);
             Cursor cursor = db.rawQuery("select * from reviewTB;",null);
                String ALL = "\n";

                while(cursor.moveToNext()){
                    ALL+= cursor.getString(0) + "\r               \r" + cursor.getInt(1) + "\r              \r" +cursor.getString(2) + "\r\n";
                }
                editAllResult.setText(ALL);
                cursor.close();
//            Cursor c = reviewTB.rawQuery("SELECT * FROM" + reviewTB, null);
//
//            if (c != null) {
//                if (c.moveToNext()) {
//                    do {
//                        String Name = c.getString(c.getColumnIndex("Name"));
//                        String Star = c.getString(c.getColumnIndex("Star"));
//                        String Info = c.getString(c.getColumnIndex("Info"));
//
//                        HashMap<String, String> reviews = new HashMap<String, String>();
//
//                        reviews.put(TAG_NAME, Name);
//                        reviews.put(TAG_STAR, Star);
//                        reviews.put(TAG_INFO, Info);
//
//                        arrData.add(reviews);
//                    } while (c.moveToNext());
//                }
//            }
            db.close();


//            adapter = new SimpleAdapter(
//                    this, arrData, R.layout.activity_review_listview,
//                    new String[]{TAG_NAME, TAG_INFO},
//                    new int[]{R.id.Name, R.id.Info}
//            );
//            list.setAdapter(adapter);
        } catch (SQLException se) {
            Toast.makeText(getApplicationContext(), se.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("", se.getMessage());
        }
    }
}
