package com.example.gouravsproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelperUser extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "p.db";
    public static final String TABLE_NAME = "students_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "SUBJECT";
    public static final String COL_3 = "ROLL";
    public static final String COL_4 = "MARKS";
    public static final String COL_5 = "NAME";
    public static final String COL_6 = "SECTION";

    DatabaseHelperUser(Context context)
    {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "SUBJECT TEXT,ROLL INTEGER,MARKS INTEGER,NAME TEXT,SECTION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    public boolean insertData(String sub,String r,String m,String n ,String se)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2,sub);
        values.put(COL_3,r);
        values.put(COL_4,m);
        values.put(COL_5,n);
        values.put(COL_6,se);
        long result = database.insert(TABLE_NAME,null,values);
        if (result == -1)
            return false;
        else return true;

    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME  , null);
        return res;
    }
    public Cursor getDataForStudent(String roll){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res = database.rawQuery("select * from students_table where ROll = " + roll,null);
        return res;
    }
   /* public boolean updataData(String s,String r,String m,String n ,String se)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,s);
        contentValues.put(COL_3,r);
        contentValues.put(COL_4,m);
        contentValues.put(COL_5,n);
        contentValues.put(COL_4,se);
        database.update(TABLE_NAME,contentValues,"ROLL = ? and SUBJECT = ?",new String[]{ r,s,n,se });
        return true;
    }*/
   public boolean updateData(String s,String r,String m) {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(COL_2,s);
       contentValues.put( COL_3,r);
       contentValues.put(COL_4,m);
       db.update(TABLE_NAME, contentValues, "ROLL = ? and SUBJECT = ?", new String[]{r,s});
       return true;
   }

    public Integer deleteData(String r)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME,"ROLL = ?",new String[]{r});
    }
}