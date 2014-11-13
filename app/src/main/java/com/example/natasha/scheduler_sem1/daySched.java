package com.example.natasha.scheduler_sem1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.natasha.scheduler_sem1.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class daySched extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_sched);

        Bundle b = getIntent().getExtras();
        String date = b.getString("date");
        dbSource sors= new dbSource(this);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date thisdate;
        TextView txt;
        LinearLayout layout= (LinearLayout) findViewById(R.id.layout);
        LinearLayout row;

       try {
           thisdate = sdf.parse(date.replace("-","/"));
           Calendar c = Calendar.getInstance();
           c.setTime(thisdate);
           String[][] events= sors.getEvents(thisdate);
           int y = events.length;
           int x = events[0].length;

           {
               row=new LinearLayout(this);

/*id integer primary key autoincrement, "+
               "name text not null,"+
                       " desc text, "+
                       "deadline date not null,"+
                       " typename text,"+
                       " remindon text
                       */
               txt = new TextView(this);
               txt.setText("ID");
               row.addView(txt);
               txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
               txt = new TextView(this);
               txt.setText("Name");
               row.addView(txt);
               txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));

               txt = new TextView(this);
               txt.setText("Description");
               row.addView(txt);
               txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));

               txt = new TextView(this);
               txt.setText("Deadline");
               row.addView(txt);
               txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));

               txt = new TextView(this);
               txt.setText("Type");
               row.addView(txt);
               txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
               txt = new TextView(this);

               txt.setText("Remind On");
               row.addView(txt);
               txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
           }
           layout.addView(row);
           row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                   LinearLayout.LayoutParams.WRAP_CONTENT,1.0f));
         //  row.setOrientation(LinearLayout.VERTICAL);


           for(int i=0; i<y; i++)
           {
               row=new LinearLayout(this);
           //    row.setOrientation(LinearLayout.VERTICAL);
               for(int j=0;j<x;j++)
               {
                   txt = new TextView(this);
                   txt.setText(events[i][j]);
                   row.addView(txt);
                   txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                           LinearLayout.LayoutParams.MATCH_PARENT,1.0f));
               }
               layout.addView(row);
               row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                       LinearLayout.LayoutParams.MATCH_PARENT,1.0f));
           }
       }
       catch(Exception ex)
       {

       }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.day_sched, menu);
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
