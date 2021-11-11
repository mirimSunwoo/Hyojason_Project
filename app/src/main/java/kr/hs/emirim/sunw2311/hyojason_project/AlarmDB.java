package kr.hs.emirim.sunw2311.hyojason_project;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class AlarmDB extends SQLiteOpenHelper {
    public AlarmDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase alarmdb) {
        Log.i("tag","db 생성_db가 없을 때만 최초로 실행함");
        onCreate(alarmdb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase alarmdb, int oldVersion, int newVersion) {
        alarmdb.execSQL("drop table if exists alarmTB");
        onCreate(alarmdb);
    }
    public void createTable(SQLiteDatabase alarmdb){
        String sql = "create table joinTB(alaname char(20), befter char(2), hour int(2), minute int(2))";
        try{
            alarmdb.execSQL(sql);
        }catch (SQLException e){

        }
    }
}
