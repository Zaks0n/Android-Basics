package com.example.sqllitedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class CoreDatabase extends SQLiteOpenHelper {


    static final private String DB_Name = "Education";
    static final private String DB_Table = "Student";
    static final  private int DB_Ver = 1;

    Context ctx;
    SQLiteDatabase myDB;

    public CoreDatabase(Context ct) {
        super(ct, DB_Name, null, DB_Ver);
        ctx = ct;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DB_Table+" (_id integer primary key autoincrement, stu_name text, col_name text);");
        Log.i("Database", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DB_Table);
        onCreate(db);
    }

    public void insertData(String s1, String s2){
        myDB = getWritableDatabase();

        myDB.execSQL("insert into "+DB_Table+" (stu_name, col_name) values('"+s1+"', '"+s2+"');");
        Toast.makeText(ctx, "Data saved successfully", Toast.LENGTH_LONG).show();
    }


    public  void getAll(){
        myDB = getReadableDatabase();

        Cursor cr = myDB.rawQuery("select * from "+DB_Table, null);
        StringBuilder str = new StringBuilder();

        while (cr.moveToNext()){
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);

            str.append(s1 + "          " +s2+ "\n");
        }

        Toast.makeText(ctx, str.toString(), Toast.LENGTH_LONG).show();
    }
}
