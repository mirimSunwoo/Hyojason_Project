package kr.hs.emirim.sunw2311.hyojason_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    int version = 3;
    DatabaseOpenHelper helper;
    SQLiteDatabase database;

    Button btnJoin;
    TextView textFind, textLogin;
    EditText idEdit, passEdit;

    String sql;
    Cursor cursor;

    CheckBox checkBox;

    SharedPreferences setting;
    SharedPreferences.Editor editor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        idEdit = findViewById(R.id.id_input);
        passEdit = findViewById(R.id.pass_input);

//        textFind = findViewById(R.id.text_find);

        textLogin = findViewById(R.id.text_login);
        btnJoin = findViewById(R.id.btn_join);

        checkBox = findViewById(R.id.check_box);

        setting = getSharedPreferences("setting", 0);
        editor=setting.edit();

        if(setting.getBoolean("chk_auto", false)){
            idEdit.setText(setting.getString("ID",""));
            passEdit.setText(setting.getString("PW", ""));
            checkBox.setChecked(true);
        }

        helper = new DatabaseOpenHelper(LoginActivity.this, DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
//                    Toast.makeText(LoginActivity.this, "?????? ?????????", Toast.LENGTH_SHORT).show();

                    String ID = idEdit.getText().toString();
                    String PW = passEdit.getText().toString();

                    editor.putString("ID", ID);
                    editor.putString("PW", PW);
                    editor.putBoolean("chk_auto", true);
                    editor.commit();

                }else{
                    editor.clear();
                    editor.commit();
                }
                String id = idEdit.getText().toString();
                String pw = passEdit.getText().toString();

                if (id.length() == 0 || pw.length() == 0){
                    Toast toast = Toast.makeText(LoginActivity.this, "???????????? ??????????????? ??????????????????.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sql = "SELECT id FROM joinTB WHERE id = '" + id + "'";
                cursor = database.rawQuery(sql, null);

                if(cursor.getCount() != 1){
                    //???????????? ???????????????.
                    Toast toast = Toast.makeText(LoginActivity.this, "????????? ?????? ??????????????? ???????????? ????????????.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                sql = "SELECT password FROM joinTB WHERE password = '" + pw + "'";

                cursor = database.rawQuery(sql, null);

                cursor.moveToNext();
                if (!pw.equals(cursor.getString(0))){
                    //??????????????? ???????????????.
                    Toast toast = Toast.makeText(LoginActivity.this, "????????? ?????? ??????????????? ???????????? ????????????.", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    //????????? ??????
                    sql = "SELECT petName FROM joinTB where id='"+id+"'";
                    cursor = database.rawQuery(sql, null);
                    cursor.moveToNext();
                    Toast toast = Toast.makeText(LoginActivity.this,cursor.getString(0)+"????????? ???????????????", Toast.LENGTH_SHORT);
                    toast.show();
                    //????????? ?????? ??? ??????
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
//        textFind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), FindActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}