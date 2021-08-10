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


        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("insert into groupTB values('"+joinPetName.getText().toString()+"',"+joinId.getText().toString()+"',"+joinPassword.getText().toString()+"',"+joinEmail+");");
                Toast.makeText(getApplicationContext(),"정상적으로 행이 삽입 되었습니다.",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
