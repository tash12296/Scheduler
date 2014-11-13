package com.example.natasha.scheduler_sem1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    /*public String getQuote(int quoteNum, String quote)
    {
         quoteNum = (int) (Math.random() * 4);
       quote="";
        switch (quoteNum) {
            case 1:
                quote = " trial1";
                break;
            case 2:
                quote= " trial2";
                break;
            case 3:
                quote = "lalala";
                break;
            case 4:
                quote = "testing";
                break;
        }

        try {
            open();
            Cursor cursor = database.rawQuery("Select quote from quote where id=quoteNum");
            cursor.moveToFirst();

            toRet= new String[]{cursor.getString(0)};

        }
        catch(SQLException sq)
        {}
        return quote;
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


    public String[][] getEvents(Date date)
    {
        List<String[]> idlist = new ArrayList<String[]>();
        String[][] toRet;
        try {
            open();

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

            String strDate = df.format(date);

            Cursor cursor = database.rawQuery("Select * from events where deadline like '"+strDate.replace("/","-")+"%' order by deadline asc", null);

            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                idlist.add(new String[]{cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)});
                cursor.moveToNext();
            }

            toRet=new String[idlist.size()][6];

            for(int i=0;i<idlist.size();i++)
            {
                toRet[i]=idlist.get(i);
            }

            return toRet;
        }
        catch(SQLException sq)
        {
            return null;
        }
    }

    public int[] getEventID(Date date)
    {
        List<Integer> idlist = new ArrayList<Integer>();
        int[] toRet;
        try {
            open();

            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

            String strDate = df.format(date);

            Cursor cursor = database.rawQuery("Select id from events where deadline like '"+strDate.replace("/","-")+"%' order by id desc", null);

            cursor.moveToFirst();

            while (!cursor.isAfterLast()) {
                idlist.add(cursor.getInt(0));
                cursor.moveToNext();
            }

            toRet=new int[idlist.size()];

            for(int i=0;i<idlist.size();i++)
            {
                toRet[i]=idlist.get(i);
            }

            return toRet;
        }
        catch(SQLException sq)
        {
            return null;
        }
    }

}