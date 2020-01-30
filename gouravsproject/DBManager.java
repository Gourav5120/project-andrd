package com.example.gouravsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
public class DBManager {
    public SQLiteDatabase sq;
     static final String DBName = "myDatabase";
     static final String TableName = "myTable";
     static final String SubjectName = "subject";
     static final String Marks = "marks";
     static final int DBVersion = 3;
     static final String createTable = "CREATE TABLE IF NOT EXISTS "+TableName
             +"(ID INTEGER PRIMARY KEY AUTOINCREMENT," + SubjectName
             +" text,"+ Marks +"text);";
private static class databaseHelperUser extends SQLiteOpenHelper{
    Context context;
    databaseHelperUser(Context context)
    {
        super(context,DBName,null,DBVersion);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTable);
        Toast.makeText(context, "table is created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table IF EXISTS "+ TableName);
        onCreate(sqLiteDatabase);
    }
}
public DBManager(Context context){
    databaseHelperUser db = new databaseHelperUser(context);
    sq = db.getWritableDatabase();
}
public long insert(ContentValues values)
{
    long ID = sq.insert(TableName," ",values);
    return  ID;
}
}
