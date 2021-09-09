package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.CHAR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ManagerActivity extends AppCompatActivity {
    ImageButton btnBack;
    ManagerActivity.MyDBHelper dbHelper;
    EditText MAname, MFname, MInfo, MDanger;
    Button MbtnCheck;
    SQLiteDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_manager);
        setTitle("관리자 DB");

        btnBack = findViewById(R.id.btn_manager_back);
        btnBack.setOnClickListener(btnBackListener);

        MAname = findViewById(R.id.btn_manager_animalName);
        MFname = findViewById(R.id.btn_manager_foodName);
        MInfo = findViewById(R.id.btn_manager_info);
        MDanger = findViewById(R.id.btn_manager_danger);

        MbtnCheck = findViewById(R.id.btn_manager_check);

        dbHelper = new ManagerActivity.MyDBHelper(this);

        MbtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO managerDB VALUES (" +
                        "'" + MAname.getText().toString() + "' ,'"
                        + MFname.getText().toString() + "' ,'"
                        + MInfo.getText().toString() + "' ,'"
                        + MDanger.getText().toString() + "');");
                db.close();
                Toast.makeText(getApplicationContext(),"정상적으로 행이 삽입 되었습니다.",Toast.LENGTH_SHORT).show();
                selectDB();
            }
        });
    }

    public void selectDB(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from managerDB;", null);
        String animalName = "동물 이름\r\n_____________\r\n";
        String foodName = "음식이름\r\n_____________\r\n";
        String info = "정보\r\n_____________\r\n";
        String danger = "위험요소(없으면0, 있으면1)\r\n_____________\r\n";
        while(cursor.moveToNext()){
            animalName+= cursor.getString(0) + "\r\n";
            foodName+=cursor.getString(1) + "\r\n";
            info+=cursor.getString(2) + "\r\n";
            danger+=cursor.getString(2) + "\r\n";
        }

        cursor.close();
        db.close();
    }
    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context){
            super(context,"managerDB",null, 2);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table managerDB(animalName char(20), foodName char(20) primary key, info char(100), danger char(5));");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists managerDB");
            onCreate(db);
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
