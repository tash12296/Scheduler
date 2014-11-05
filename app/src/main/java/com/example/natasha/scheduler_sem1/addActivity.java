package com.example.natasha.scheduler_sem1;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.sql.SQLException;
import java.util.Calendar;

public class addActivity extends ActionBarActivity{
    EditText inputDate, inputTime, descriptionInput, deadlineInputDate,deadlineInputTime,remindonInputDate, remindonInputTime;
    Button saveButton;
    Spinner editType;



    public void onClick(View v) {


    if (  v == inputDate )
    {
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR);
    int mMonth = c.get(Calendar.MONTH);
    int mDay = c.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog dpd = new DatePickerDialog(this,
            new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    inputDate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                }
            }, mYear, mMonth, mDay
    );
    dpd.show();
    }

    else if (v == inputTime)
    {
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // Display Selected time in textbox
                        inputTime.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }

        else if( v == saveButton){

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Setting Dialog Title
        alertDialog.setTitle("Scheduler");

        dbSource sors = new dbSource(this);
        sors.addEvent(descriptionInput.getText().toString(),descriptionInput.getText().toString(),(deadlineInputDate.getText().toString()+" "+deadlineInputTime.getText().toString()).replace("/","-"),editType.getSelectedItem().toString(),(remindonInputDate.getText()+" "+remindonInputTime.getText()).replace("/","-"));
        //public void addEvent(       String name,                   String Desc,                             String deadline,                                                                                           String typename,                                                             String remindon)
        // Setting Dialog Message
        alertDialog.setMessage("Schedule has been saved");
        //alertDialog.b

        // Setting Icon to Dialog
       // alertDialog.setIcon(R.drawable.success);

        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Write your code here to execute after dialog closed
                startActivity(new Intent(getApplication(),MyActivity.class));
            }
        });

        // Showing Alert Message
        alertDialog.show();

    }

        else if (v == deadlineInputDate){

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        deadlineInputDate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay
        );
        dpd.show();

    }
        else if(v == deadlineInputTime){
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // Display Selected time in textbox
                        deadlineInputTime.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }

    else if (v == remindonInputDate){

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        remindonInputDate.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay
        );
        dpd.show();

    }
    else if(v == remindonInputTime){
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // Display Selected time in textbox
                        remindonInputTime.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        tpd.show();

        /*dbSource sors=new dbSource(this);
        sors.getQuote();*/
    }


    }//onClick inPutDate inputDate.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);
       // inputTime = (EditText) findViewById(R.id.inputTime);
       // inputDate = (EditText) findViewById(R.id.inputDate);
        deadlineInputDate = (EditText) findViewById(R.id.deadlineInputDate);
        remindonInputDate = (EditText) findViewById(R.id.remindonInputDate);
        deadlineInputTime = (EditText) findViewById(R.id.deadlineInputTime);
        remindonInputTime = (EditText) findViewById(R.id.remindonInputTime);
        editType = (Spinner) findViewById(R.id.editType);
        saveButton = (Button) findViewById(R.id.saveButton);

    }

    public void buttonOnSave(View v){
        Button save=(Button)v;
        //((Button) v).setText("Stop");0
        startActivity(new Intent(getApplication(),MyActivity.class));

        dbSource sors = new dbSource(this);


        sors.addEvent(descriptionInput.getText().toString(),descriptionInput.getText().toString(),(deadlineInputDate.getText().toString()+" "+deadlineInputTime.getText().toString()).replace("/","-"),editType.getSelectedItem().toString(),(remindonInputDate.getText()+" "+remindonInputTime.getText()).replace("/","-"));
        //public void addEvent(       String name,                String Desc,
    }


    public void buttonOnBack(View v){
        Button back=(Button)v;
        finish();
        //((Button) v).setText("Stop");0
        //startActivity(new Intent(getApplication(),MyActivity.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    /*
    public static class PlaceholderFragment extends Fragment {

        EditText inputDate, inputTime;



        public PlaceholderFragment() {
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_add, container, false);

            inputTime = (EditText) rootView.findViewById(R.id.inputTime);
            inputDate = (EditText) rootView.findViewById(R.id.inputDate);

            return rootView;
        }
    }
    */
}