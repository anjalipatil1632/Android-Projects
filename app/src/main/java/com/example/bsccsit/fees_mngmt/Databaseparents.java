package com.example.bsccsit.fees_mngmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databaseparents extends SQLiteOpenHelper
{
    public final static String DATABASE_NAME = "parent_Database.db";
    public final static String TABLE_NAME = "parent_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "ROLLNO";
    public static final String COL_3 = "CLASS";
    public static final String COL_4 = "PHONENO";
    public static final String COL_5 = "EMAIL";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "CONFIRM_PASSSWORD ";


    public Databaseparents(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(NAME TEXT, ROLLNO INTEGER ,CLASS TEXT,PHONENO TEXT,EMAIL TEXT,PASSWORD TEXT,CONFIRM_PASSSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insert(String name,String rollno,String class1,String phn,String email,String pass,String cpass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_1, name);
        cv.put(COL_2, rollno);
        cv.put(COL_3, class1);
        cv.put(COL_4, phn);
        cv.put(COL_5, email);
        cv.put(COL_6, pass);
        cv.put(COL_7, cpass);


        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) return false;
        else return true;
    }
}
