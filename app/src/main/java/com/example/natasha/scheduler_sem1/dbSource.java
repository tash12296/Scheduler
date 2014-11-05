package com.example.natasha.scheduler_sem1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Natasha on 10/26/2014.
 */
public class dbSource {
    private SQLiteDatabase database;
    private dbHelper dbHelp;

    public dbSource(Context context)
    {
        dbHelp = new dbHelper(context);
    }

    public void open() throws SQLException {
        database= dbHelp.getWritableDatabase();
    }

    public void close(){
        dbHelp.close();
    }

    public void addEvent(String name, String Desc, String deadline, String typename, String remindon)
    {
        //DateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sql= "insert into events(name, desc, deadline, typename, remindon) values ('"+name+"','"+Desc+"','"+deadline+"','"+typename+"','"+remindon+"')";

        try {
            open();
            database.execSQL(sql);
            close();
        }catch(SQLException sq)
        {

        }
    }

    /*public String getQuote()
    {
        return quoteko;
    }*/

    public String[] first()
    {
        String[] toRet={};

        try {
            open();
            Cursor cursor = database.rawQuery("Select name, desc, deadline, typename, remindon from events order by id desc", null);
            cursor.moveToFirst();

            toRet= new String[]{cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)};

        }
        catch(SQLException sq)
        {}

        return toRet;
    }
}