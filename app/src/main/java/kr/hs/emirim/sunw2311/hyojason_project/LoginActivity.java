package kr.hs.emirim.sunw2311.hyojason_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    int version = 1;
    DatabaseOpenHelper helper;
    SQLiteDatabase database;

    Button btnJoin;
    TextView textFind, textLogin;
    EditText idEdit, passEdit;

    String sql;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEdit = findViewById(R.id.id_input);
        passEdit = findViewById(R.id.pass_input);

        textFind = findViewById(R.id.text_find);

        textLogin = findViewById(R.id.text_login);
        btnJoin = findViewById(R.id.btn_join);

        helper = new DatabaseOpenHelper(LoginActivity.this, DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idEdit.getText().toString();
                String pw = passEdit.getText().toString();

                if (id.length() == 0 || pw.length() == 0){
                    Toast toast = Toast.makeText(LoginActivity.this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sql = "SELECT id FROM joinTB WHERE id = '" + id + "'";
                cursor = database.rawQuery(sql, null);

                if(cursor.getCount() != 1){
                    //아이디가 틀렸습니다.
                    Toast toast = Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sql = "SELECT password FROM joinTB WHERE password = '" + pw + "'";

                cursor = database.rawQuery(sql, null);

                cursor.moveToNext();
                if (!pw.equals(cursor.getString(0))){
                    //비밀번호가 틀렸습니다.
                    Toast toast = Toast.makeText(LoginActivity.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    //로그인 성공
                    sql = "SELECT petName FROM joinTB where id='"+id+"'";
                    cursor = database.rawQuery(sql, null);
                    cursor.moveToNext();
                    Toast toast = Toast.makeText(LoginActivity.this,cursor.getString(0)+"주인님 환영합니다", Toast.LENGTH_SHORT);
                    toast.show();
                    //인텐트 생성 및 호출
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                    finish();
                }
                cursor.close();
            }
        });
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
                finish();
            }
        });
        textFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FindActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}