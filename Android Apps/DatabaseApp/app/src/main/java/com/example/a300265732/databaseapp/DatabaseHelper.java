package com.example.a300265732.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "information.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE1_NAME = "Student_table";
    final static String TABLE2_NAME = "Province_table";
    final static String T1COL1 = "Id";
    final static String T1COL2 = "Fname";
    final static String T1COL3 = "Lname";
    final static String T1COL4 = "CNumber";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE1_NAME + " ( " + T1COL1 + " INTEGER PRIMARY KEY," + T1COL2 + " Text," + T1COL3 + " Text,"
                + T1COL4 + " Text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        onCreate(db);
    }

    public boolean addRecord(String fn, String ln, String cel) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ContentValues value = new ContentValues();
        value.put(T1COL2, fn);
        value.put(T1COL3, ln);
        value.put(T1COL4, cel);
        long r = sqLiteDatabase.insert(TABLE1_NAME, null, value);

        if (r > 0) {
            return true;

        } else {
            return false;
        }

    }

    public Cursor viewdata() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "Select * from " + TABLE1_NAME;
        Cursor c = sqLiteDatabase.rawQuery(query, null);
        return c;
    }

   /* public boolean deleteRecord (int id)
    {
        SQLiteDatabase sqLiteDatabase = this .getReadableDatabase();
        String query = "DELETE FROM "+ TABLE1_NAME +" WHERE " + T1COL1 + " = " + id;
        sqLiteDatabase.execSQL(query);
        return true;
    }*/

    public boolean delRec(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int d = sqLiteDatabase.delete(TABLE1_NAME, "id = ?", new String[]{Integer.toString(id)});
        if (d > 0) {
            return true;
        } else {
            return false;
        }

    }

  /* public boolean updateRecord(int id,String c)
   {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String query = "Update " + TABLE1_NAME + "set CNumber = " + c  +" WHERE Id = " + id;
        sqLiteDatabase.execSQL(query);
        return true;
   }*/

    public boolean updateRec(int id, String c) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL4, c);
        int d = sqLiteDatabase.update(TABLE1_NAME, values, "id=?", new String[]{Integer.toString(id)});
        if (d > 0) {
            return true;
        } else
            return false;

    }
}
