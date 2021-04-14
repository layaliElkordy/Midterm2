package com.example.midterm2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users_data";
    public static final String c1 = "ID";
    public static final String c2 = "Name";
    public static final String c3 = "Email";
    public static final String c4 = "Phone_number";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME +" ( "
                + c1 +" INTEGER PRIMARY KEY , "+
                c2 +" TEXT NOT NULL, " +
                c3 +" TEXT NOT NULL, " +
                c4 +" TEXT NOT NULL) ");

    }
    public boolean adduser(String id, String name, String email,String number){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(c1,id);
        values.put(c2,name);
        values.put(c3, email);
        values.put(c4,number);
        db.insert(TABLE_NAME,null, values);
        return true;
    }
    public Cursor getSpecificResult(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = ?", new String[]{id});
        if (data != null)
            data.moveToFirst();
        return data;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor x = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return x;
    }
    public Integer deletedata(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id}); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
