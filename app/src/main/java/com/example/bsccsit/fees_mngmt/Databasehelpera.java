package com.example.bsccsit.fees_mngmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Databasehelpera extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "admin_Database.db";
    public final static String TABLE_NAME = "admintable_imp_fycs";
    public final static String TABLE_NAME1 = "admin_table";
    public final static String TABLE_NAME3 = "admin_table_sycs";
    public final static String TABLE_NAME4 = "admin_table_tycs";
    public static final String COL_8 = "USERNAME";
    public static final String COL_9 = "PASSWORD";

    public static final String COL_1 = "ROLLNO";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "CLASS";
    public static final String COL_4 = "FIRST_INSTALLMENT";
    public static final String COL_5 = "TUITION_FEES ";
    public static final String COL_6 = "COMPUTER_FEES";
    public static final String COL_7 = "ID_FEES";
    public static final String COL_10 = "PAID_DATE";
    public static final String COL_11 = "DUE_DATE";



    public static final String COL_13 = "ROLLNO";
    public static final String COL_14 = "NAME";
    public static final String COL_15 = "CLASS";
    public static final String COL_16 = "FIRST_INSTALLMENT";
    public static final String COL_17 = "TUITION_FEES ";
    public static final String COL_18 = "COMPUTER_FEES";
    public static final String COL_19 = "ID_FEES";
    public static final String COL_20 = "PAID_DATE";
    public static final String COL_21 = "DUE_DATE";


    public static final String COL_23 = "ROLLNO";
    public static final String COL_24 = "NAME";
    public static final String COL_25 = "CLASS";
    public static final String COL_26 = "FIRST_INSTALLMENT";
    public static final String COL_27 = "TUITION_FEES ";
    public static final String COL_28 = "COMPUTER_FEES";
    public static final String COL_29 = "ID_FEES";
    public static final String COL_30 = "PAID_DATE";
    public static final String COL_31 = "DUE_DATE";


    public Databasehelpera(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ROLLNO INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CLASS TEXT,FIRST_INSTALLMENT TEXT,TUITION_FEES TEXT,COMPUTER_FEES TEXT,ID_FEES TEXT,PAID_DATE TEXT,DUE_DATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME3 + "(ROLLNO INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CLASS TEXT,FIRST_INSTALLMENT TEXT,TUITION_FEES TEXT,COMPUTER_FEES TEXT,ID_FEES TEXT,PAID_DATE TEXT,DUE_DATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME4 + "(ROLLNO INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,CLASS TEXT,FIRST_INSTALLMENT TEXT,TUITION_FEES TEXT,COMPUTER_FEES TEXT,ID_FEES TEXT,PAID_DATE TEXT,DUE_DATE TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "(USERNAME TEXT,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }


    public boolean insert1(String name, String surname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_8, name);
        cv.put(COL_9, surname);
        long result = db.insert(TABLE_NAME1, null, cv);
        if (result == -1) return false;
        else return true;
    }

    public boolean insert(String name,String class1,String firsti,String tutionf,String compf,String classf,String pdate,String ddate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_2, name);
        cv.put(COL_3, class1);
        cv.put(COL_4, firsti);
        cv.put(COL_5, tutionf);
        cv.put(COL_6, compf);
        cv.put(COL_7, classf);
        cv.put(COL_10, pdate);
        cv.put(COL_11, ddate);


        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) return false;
        else return true;
    }

    public boolean insert3(String name,String class1,String firsti,String tutionf,String compf,String classf,String pdate,String ddate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_14, name);
        cv.put(COL_15, class1);
        cv.put(COL_16, firsti);
        cv.put(COL_17, tutionf);
        cv.put(COL_18, compf);
        cv.put(COL_19, classf);
        cv.put(COL_20, pdate);
        cv.put(COL_21, ddate);

        long result = db.insert(TABLE_NAME3, null, cv);
        if (result == -1) return false;
        else return true;
    }
    public boolean insert4(String name,String class1,String firsti,String tutionf,String compf,String classf,String pdate,String ddate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_24, name);
        cv.put(COL_25, class1);
        cv.put(COL_26, firsti);
        cv.put(COL_27, tutionf);
        cv.put(COL_28, compf);
        cv.put(COL_29, classf);
        cv.put(COL_30, pdate);
        cv.put(COL_31, ddate);

        long result = db.insert(TABLE_NAME4, null, cv);
        if (result == -1) return false;
        else return true;
    }





    public Cursor getData(String id,String class2){
        SQLiteDatabase db = this.getWritableDatabase();
        if (class2.equals("FYBSC CS"))
        {
            String query="SELECT * FROM "+TABLE_NAME+" WHERE ROLLNO='"+id+"' AND CLASS='FYBSC CS'";
            Cursor  cursor = db.rawQuery(query,null);
            return cursor;
        }
        else if (class2.equals("SYBSC CS"))
        {
            String query="SELECT * FROM "+TABLE_NAME3+" WHERE ROLLNO='"+id+"' AND CLASS='SYBSC CS'";
            Cursor  cursor = db.rawQuery(query,null);
            return cursor;
        }

            String query = "SELECT * FROM " + TABLE_NAME4 + " WHERE ROLLNO='" + id + "' AND CLASS='TYBSC CS'";
            Cursor cursor = db.rawQuery(query, null);
            return cursor;


        /*
        String query1="SELECT * FROM "+TABLE_NAME3+" WHERE ROLLNO='"+id+"' AND CLASS='SYBSC CS'";
        String query2="SELECT * FROM "+TABLE_NAME4+" WHERE ROLLNO='"+id+"' AND CLASS='TYBSC CS'";

        Cursor  cursor = db.rawQuery(query,null);
        Cursor  cursor = db.rawQuery(query,null);*/


    }



    public boolean updateData(String rollno,String name,String class1,String firsti,String tutionf,String compf,String classf,String pdate,String ddate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, rollno);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, class1);
        contentValues.put(COL_4, firsti);
        contentValues.put(COL_5, tutionf);
        contentValues.put(COL_6, compf);
        contentValues.put(COL_7, classf);
        contentValues.put(COL_10, pdate);
        contentValues.put(COL_11, ddate);



        if (class1.equals("FYBSC CS")) {
            db.update(TABLE_NAME, contentValues, "ROLLNO=?", new String[]{rollno});
            return true;
        }
        else if (class1.equals("SYBSC CS")) {
            db.update(TABLE_NAME3, contentValues, "ROLLNO=?", new String[]{rollno});
            return true;
        }
        else if (class1.equals("TYBSC CS")) {
            db.update(TABLE_NAME4, contentValues, "ROLLNO=?", new String[]{rollno});
            return true;
        }
        return true;

    }

    public Integer deleteData (String id,String class2) {
            SQLiteDatabase db = this.getWritableDatabase();
            if(class2.equals("FYBSC CS")) {
                return db.delete(TABLE_NAME, "ROLLNO = ? ", new String[]{id});
            }
            else if(class2.equals("SYBSC CS")) {
                return db.delete(TABLE_NAME3, "ROLLNO = ? ", new String[]{id});
            }

            return db.delete(TABLE_NAME4, "ROLLNO = ? ", new String[]{id});



    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        return res;
    }

    public Cursor getAllData3() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME3, null);
        return res;
    }
    public Cursor getAllData4() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME4, null);
        return res;
    }}







