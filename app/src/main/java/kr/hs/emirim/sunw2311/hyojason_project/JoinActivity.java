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
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.CHAR;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class JoinActivity extends AppCompatActivity {
    MyDBHelper dbHelper;
    EditText joinId, joinPassword, joinPetName, joinEmail, editNamesResult, editIdresult;
    Button btnJoin;
    ImageButton btnBack;
    SQLiteDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        setTitle("회원가입 DB");

        btnBack = findViewById(R.id.btn_join_back);
        btnBack.setOnClickListener(btnBackListener);

        joinEmail = findViewById(R.id.join_email);
        joinId = findViewById(R.id.join_id);
        joinPassword = findViewById(R.id.join_password);
        joinPetName = findViewById(R.id.join_petName);

        btnJoin = findViewById(R.id.btn_join);

        editNamesResult = findViewById(R.id.edtNameResult);
        editIdresult = findViewById(R.id.edtIdResult);
//        listCheck = findViewById(R.id.list_check);
//        listCheck.setOnClickListener(listListener);

        dbHelper = new MyDBHelper(this);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT INTO groupTB VALUES (" +
                        "'" + joinPetName.getText().toString() + "' ,"
                        + joinId.getText().toString() + "' ,"
                        + joinPassword.getText().toString() + "' ,"
                        + joinEmail.getText().toString() + ");");
                db.close();
                Toast.makeText(getApplicationContext(),"정상적으로 행이 삽입 되었습니다.",Toast.LENGTH_SHORT).show();
                selectDB();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //    View.OnClickListener listListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(getApplicationContext(), ListViewActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    };
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
//        joinPetName.setText(petName);
//        joinId.setText(Id);
//        joinPassword.setText(password);
//        joinEmail.setText(email);
        editNamesResult.setText(petName);
        editIdresult.setText(Id);

        cursor.close();
        db.close();
    }
    public class MyDBHelper extends SQLiteOpenHelper {

        public MyDBHelper(Context context){
            super(context,"groupTB",null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table groupTB(petName char(20) primary key, id char, password char, email char);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists groupTB");
            onCreate(db);
        }
    }
    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    };
}