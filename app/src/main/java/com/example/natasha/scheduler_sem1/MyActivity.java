package com.example.natasha.scheduler_sem1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;



public class MyActivity extends ActionBarActivity {

EditText randomQuotes;
    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

       // randomQuotes = (EditText) findViewById(R.id.randomQuotes);


        //randomQuotes.setText()
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    public void calendarView(View v){
       CalendarView calendar=(CalendarView)v;
        startActivity(new Intent(getApplication(),calendarView.class));

     }

    public void buttonOnClickAdd(View v){

        Button add=(Button)v;
        //((Button) v).setText("Stop");0
        startActivity(new Intent(getApplication(),addActivity.class));
    }

    public void buttonOnClickView(View v){

        Button view=(Button)v;
        //((Button) v).setText("Stop");
        startActivity(new Intent(getApplication(),view.class));
    }
    public void randomQuotes(View v) {
        Button quotes = (Button) v;


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



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            return rootView;
        }
    }
}
