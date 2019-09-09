package com.example.mbashir1.databasemultipletablesapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    final static String DATABASE_NAME = "Information.db";
    final static int DATABASE_VERSION = 4;
    final static String TABLE1_NAME = "Student_table";
    final static String TABLE2_NAME = "Province_table";
    final static String T1COL_1 = "Id";
    final static String T1COL_2 = "FName";
    final static String T1COL_3 = "LName";
    final static String T1COL_4 = "CNumber";
    final static String T1COL_5 = "ProvId";

    final static String T2COL_1 = "ProvId";
    final static String T2COL_2 = "ProvName";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating student_table and province_table
        String query = "Create Table " + TABLE1_NAME + "(" + T1COL_1 + " INTEGER PRIMARY KEY ," +
                T1COL_2 + " Text," + T1COL_3 + " Text," + T1COL_4 + " Text," + T1COL_5 + " Text)";
        String pQuery = "Create Table " + TABLE2_NAME + "(" + T2COL_1 + " Text," + T2COL_2 + " Text)";
        try{
            db.execSQL(query);
            db.execSQL(pQuery);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE1_NAME);
        db.execSQL("Drop table if exists " + TABLE2_NAME);
        onCreate(db);
    }

    //method to add student record
    public boolean addRec(String fn,String ln,String cell,String pid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL_2,fn);
        values.put(T1COL_3,ln);
        values.put(T1COL_4,cell);
        values.put(T1COL_5,pid);
        long r = db.insert(TABLE1_NAME,null,values);
        if(r == -1){
            return  false;
        }
        else{
            return true;
        }
    }

    //method to view data
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + TABLE1_NAME;
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    //method to add province records
    public boolean addRecProvince(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(T2COL_1,"BC");
        values.put(T2COL_2,"British Columbia");
        long r = sqLiteDatabase.insert(TABLE2_NAME,null,values);
        if(r == -1){
            return false;
        }
        else{
            return true;
        }
    }

    //method to view province records
    public Cursor viewProvinceRec(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * from " + TABLE2_NAME;
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return c;
    }

    //methods to view data from both tables using inner join
    public Cursor viewProvStudRec() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        //inner join query to extract  data from both tables where provId is same
        String query = "select Id, FName, LName, ProvName from " +
                "Student_table inner join Province_table on Student_table.ProvId "+
                "= Province_table.ProvId";
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }
}
