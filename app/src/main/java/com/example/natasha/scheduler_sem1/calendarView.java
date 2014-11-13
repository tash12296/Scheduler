package com.example.natasha.scheduler_sem1;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.natasha.scheduler_sem1.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calendarView extends ActionBarActivity {

    GridView grid;
    TableLayout tableLayout;
    int month;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);
        Date today = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        month=cal.get(Calendar.MONTH);
        year=cal.get(Calendar.YEAR);

/*      grid=(GridView) findViewById(R.id.gridView);
        grid[0].*/
        tableLayout = (TableLayout)findViewById(R.id.tbl);
        createTable();

        //TableRow row = new TableRow(this);
    }

    public boolean isThisDateValid(String dateToValidate, String dateFromat){

        if(dateToValidate == null){
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
            System.out.println(date);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void createTable()
    {
        TableRow tbRow;
        TextView txt;
        Date date;

        dbSource dbsors = new dbSource(this);
        int[] idlist;

        int day=1;

        tbRow = new TableRow(this);
        for(int j=1; j<8;j++)
        {
            txt = new TextView(this);
            txt.setTextSize(12);
            txt.setTextColor(Color.parseColor("#0066FF"));
            txt.setTypeface(null, Typeface.BOLD);
            txt.setText(""+getDayOfWeek(j));
            tbRow.addView(txt);
            txt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT,1.0f));
        }

        tableLayout.addView(tbRow);
        tbRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT, 1.0f));

        for(int i=0; i<6; i++) {

            tbRow = new TableRow(this);
            for(int j=1; j<8;j++) {
                if (isThisDateValid((month+1) + "/" + day + "/" + year, "MM/dd/yyyy")) {
                     txt = new TextView(this);
                     txt.setTextSize(12);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

                    try {
                        date=sdf.parse(year + "/" + (month+1) + "/" + day);
                        Calendar c = Calendar.getInstance();
                        c.setTime(date);
                        if(j==c.get(Calendar.DAY_OF_WEEK)) {
                            txt.setText(day + "");
                            idlist= dbsors.getEventID(date);

                            if (idlist!=null && idlist.length>0) {
                                txt.setTextColor(Color.parseColor("#66FF66"));
                                txt.setTypeface(null, Typeface.BOLD);
                                txt.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        TextView tx= (TextView) v;
                                        Intent intent = new Intent(getApplication(), daySched.class);
                                        Bundle b = new Bundle();
                                        b.putString("date", year+"-"+(month+1)+"-"+tx.getText()); //Your id
                                        intent.putExtras(b); //Put your id to your next Intent
                                        startActivity(intent);
                                    }
                                });
                            } else {
                                txt.setTypeface(null, Typeface.NORMAL);
                            }


                            day++;
                        }
                        else{
                            txt.setText("");
                        }
                            tbRow.addView(txt);
                            txt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                                    TableRow.LayoutParams.MATCH_PARENT,1.0f));
                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                    }
                }


            }

            tableLayout.addView(tbRow);
            tbRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
            //tableLayout.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT,
            //        TableRow.LayoutParams.WRAP_CONTENT));
        }
    }

    String getDayOfWeek(int i){

        String toRet="";

        switch(i)
        {
            case 2: toRet = "M"; break;
            case 3: toRet = "T"; break;
            case 4: toRet = "W"; break;
            case 5: toRet = "Th"; break;
            case 6: toRet = "F"; break;
            case 7: toRet = "S"; break;
            case 1: toRet = "Su"; break;
            default: toRet= "error";
        }

        return toRet;

    }

    String getMonthString(Date date)
    {
        String toRet="";

        int intMonth=date.getMonth()+1;
        switch(intMonth)
        {
            case 1: toRet = "January"; break;
            case 2: toRet = "February"; break;
            case 3: toRet = "March"; break;
            case 4: toRet = "April"; break;
            case 5: toRet = "May"; break;
            case 6: toRet = "June"; break;
            case 7: toRet = "July"; break;
            case 8: toRet = "August"; break;
            case 9: toRet = "September"; break;
            case 10: toRet = "October"; break;
            case 11: toRet = "November"; break;
            case 12: toRet = "December"; break;
            default: toRet="error";
        }

        return toRet;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calendar_view, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
