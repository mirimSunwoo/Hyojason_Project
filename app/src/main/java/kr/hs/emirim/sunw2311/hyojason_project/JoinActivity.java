package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class JoinActivity extends AppCompatActivity {
    MyDBHelper dbHelper;
    EditText joinId, joinPassword, joinPetName, joinEmail;
    TextView listCheck, btnJoin;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        ActionBar abar = getSupportActionBar();
        abar.hide();
        joinEmail = findViewById(R.id.join_email);
        joinId = findViewById(R.id.join_id);
        joinPassword = findViewById(R.id.join_password);
        joinPetName = findViewById(R.id.join_petName);

        btnJoin = findViewById(R.id.btn_join);

        listCheck = findViewById(R.id.list_check);
        listCheck.setOnClickListener(listListener);

        dbHelper = new MyDBHelper(this);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("insert into groupTB values('"+joinPetName.getText().toString()+"',"+joinId.getText().toString()+"',"+joinPassword.getText().toString()+"',"+joinEmail+");");
                Toast.makeText(getApplicationContext(),"정상적으로 행이 삽입 되었습니다.",Toast.LENGTH_SHORT).show();
                selectDB();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    View.OnClickListener listListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
            startActivity(intent);
            finish();
        }
    };
    public void selectDB(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from groupTB;", null);
        String petName = "펫 이름\r\n_____________\r\n";
        String Id = "아이디\r\n_____________\r\n";
        String password = "비밀번호\r\n_____________\r\n";
        String email = "이메일\r\n_____________\r\n";
        while(cursor.moveToNext()){
            petName+= cursor.getString(0) + "\r\n";
            Id+=cursor.getInt(1) + "\r\n";
            password+=cursor.getInt(2) + "\r\n";
            email+=cursor.getInt(2) + "\r\n";
        }
        joinPetName.setText(petName);
        joinId.setText(Id);
        joinPassword.setText(password);
        joinEmail.setText(email);

        cursor.close();
        db.close();
    }
    public class MyDBHelper extends SQLiteOpenHelper {

        public MyDBHelper(Context context){
            super(context,"groupDB",null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table groupTB(name char(20) primary key, id char, password char, email char);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists groupTB");
            onCreate(db);
        }
    }
}