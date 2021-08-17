package kr.hs.emirim.sunw2311.hyojason_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ex_Join extends AppCompatActivity {
    MyDBHelper dbHelper;
    EditText editName, editCount, editNameResult, editCountResult;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_join);

        editName = findViewById(R.id.edit_name);
        editNameResult = findViewById(R.id.edit_name_result);
        Button btnInput = findViewById(R.id.btn_input);

        dbHelper = new MyDBHelper(this);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = dbHelper.getWritableDatabase();
                String name = editName.getText().toString();
                db.execSQL("INSERT INTO groupTB2 VALUES('" + name+ "');");
                Toast.makeText(getApplicationContext(), "정상적으로 행이 삽입 되었습니다.", Toast.LENGTH_SHORT).show();
                selectDB();
            }
        });

    }
    public void selectDB(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from groupTB2;", null);
        String strName = "그룹 이름\r\n_____________\r\n";
        while(cursor.moveToNext()){
            strName+= cursor.getString(0) + "\r\n";
        }
        editNameResult.setText(strName);

        cursor.close();
        db.close();
    }


    public class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(Context context){
            super(context,"groupDB",null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table groupTB2(name char(20) primary key);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("drop table if exists groupTB2");
            onCreate(db);
        }
    }
}