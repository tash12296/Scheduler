package com.example.natasha.scheduler_sem1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Natasha on 10/26/2014.
 */
public class dbHelper extends SQLiteOpenHelper {

    private static final String strCreate="create table events (id integer primary key autoincrement, "+
            "name text not null,"+
            " desc text, "+
            "deadline date not null,"+
            " typename text,"+
            " remindon text)";

    private static final String strCreate1="create table types (typename text primary key, "+
            "ringtone text not null)";

    private static final String strCreate2 = "create table quote (id integer primary key, quote text)";

    public dbHelper(Context context)
    {
        super(context, "awesomeDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(strCreate);
        db.execSQL(strCreate1);
        db.execSQL(strCreate2);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(dbHelper.class.getName(), "Upgradingdatabase from version" + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXIST " + "awsomeDB");
        onCreate(db);
    }
}