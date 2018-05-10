package com.example.jo.stuff;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Stuffplusplus.db";
    public static final String TABLE_NAME = "Books Table";
    public static final String COL1 = "ID";
    public static final String COL2 = "BOOKTITLE";
    public static final String COL3 = "AUTHOR_LN";
    public static final String COL4 = "AUTHOR_FN";
    public static final String COL5 = "GENRE";
    public static final String COL6 = "CONDITION";
    public static final String COL7 = "Edition";


    public DBhelper(Context context)
    {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + DATABASE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, BOOKTITLE TEXT, AUTHORLN TEXT, AUTHORFN TEXT, GENRE TEXT, CONDITION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean insertData(String bookTitle,String authorLn, String authorFn, String genre, String condition, String edition)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,bookTitle);
        contentValues.put(COL3,authorLn);
        contentValues.put(COL4,authorFn);
        contentValues.put(COL5,genre);
        contentValues.put(COL6,condition);
        contentValues.put(COL7,edition);
        long result = db.insert(TABLE_NAME,null, contentValues);
        if(result == -1)
        {
            return false;
        } else
        {
            return true;
        }
    }
}