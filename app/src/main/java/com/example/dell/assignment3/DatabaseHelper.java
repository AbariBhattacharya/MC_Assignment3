package com.example.dell.assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DELL on 01-10-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="user.db";
    public static final String TABLE_NAME="userTable";
    public static final String COL1="FirstName";
    public static final String COL2="LastName";
    public static final String COL3="UserName";
    public static final String COL4="Password";
    public static final String COL5="PhoneNo";





    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " +TABLE_NAME+ "(FirstName TEXT,LastName TEXT,UserName TEXT PRIMARY KEY,Password TEXT,PhoneNo INTEGER);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop Table if exists"+TABLE_NAME);
        onCreate(db);
      }
    public boolean insertData(String firstName,String lastName,String userName,String password,String phoneNo){
       SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,firstName);
        contentValues.put(COL2,lastName);
        contentValues.put(COL3,userName);
        contentValues.put(COL4,password);
        contentValues.put(COL5,phoneNo);
       long result= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
       if (result==-1)
           return false;
        else return true;
    }
    public Cursor getData(String UserN){
       SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("Select * from" + TABLE_NAME + "where userName = " +UserN+ "", null );
        return res;
    }
}
