package com.example.bsccsit.fees_mngmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "Student_Database.db";
    public final static String TABLE_NAME = "student_table";
    public final static String TABLE_NAME1 = "studentfycs_registration";
    public static final String COL_11= "ID";
    public static final String COL_21= "NAME";
    public static final String COL_22 = "ROLLNO";
    public static final String COL_23= "CLASS";
    public static final String COL_24= "EMAIL";
    public static final String COL_25 = "USERNAME";
    public static final String COL_26 = "PASSWORD";
    public static final String COL_27 = "CONFIRM_PASSWORD";
    public static final String COL_28 = "PHONE_NO";



    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PASSWORD";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(USERNAME TEXT,PASSWORD TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,ROLLNO INTEGER ,CLASS TEXT,EMAIL TEXT,USERNAME TEXT,PASSWORD TEXT,CONFIRM_PASSWORD TEXT,PHONE_NO TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public boolean insert1(String name,String roll,String class1,String email,String urnm,String pass,String cpass,String phn) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_21, name);
        cv.put(COL_22, roll);
        cv.put(COL_23, class1);
        cv.put(COL_24, email);
        cv.put(COL_25, urnm);
        cv.put(COL_26, pass);
        cv.put(COL_27, cpass);
        cv.put(COL_28,phn);
        long result = db.insert(TABLE_NAME1, null, cv);
        if (result == -1) return false;
        else return true;


    }


    public boolean insert(String name, String surname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, name);
        cv.put(COL_3, surname);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) return false;
        else return true;
    }
    public boolean checkuser(String usrnm,String password)
    {
        String[] columns={COL_11};
        SQLiteDatabase db=getReadableDatabase();
        String selection= COL_25 + "=?" + " and " + COL_26 + "=?";
        String[] selectionargs={usrnm,password};
        Cursor cursor=db.query(TABLE_NAME1,columns,selection,selectionargs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        if (count>0)
            return true;
        else
            return false;
    }

    public Cursor getData(String id,String class2){
        SQLiteDatabase db = this.getWritableDatabase();

            String query="SELECT * FROM "+TABLE_NAME1+" WHERE ROLLNO='"+id+"' AND CLASS='"+class2+"'";
            Cursor  cursor = db.rawQuery(query,null);
            return cursor;







}}
