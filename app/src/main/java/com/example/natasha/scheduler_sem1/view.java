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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

public class view extends ActionBarActivity{
    EditText inputDate, inputTime, deadlineInputDate,deadlineInputTime,remindonInputDate, remindonInputTime, descriptionInput;
    Spinner editType;
    Button saveButton, deleteButton;

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
        }

        else if( v == deleteButton){

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            // Setting Dialog Title
            alertDialog.setTitle("Deleting Schedule");

            // Setting Dialog Message
            alertDialog.setMessage("Delete something");
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
       // inputTime = (EditText) findViewById(R.id.inputTime);
       // inputDate = (EditText) findViewById(R.id.inputDate);
        deadlineInputDate = (EditText) findViewById(R.id.deadlineInputDate);
        remindonInputDate = (EditText) findViewById(R.id.remindonInputDate);
        deadlineInputTime = (EditText) findViewById(R.id.deadlineInputTime);
        remindonInputTime = (EditText) findViewById(R.id.remindonInputTime);
        saveButton = (Button) findViewById(R.id.saveButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        editType = (Spinner) findViewById(R.id.editType);
        descriptionInput = (EditText) findViewById (R.id.descriptionInput);

        dbSource sors= new dbSource(this);
        String[] result= sors.first();

        //inputTime.setText(result[2].split(" ")[1]);
        //inputDate.setText (result[2].split(" ")[0]);
        descriptionInput.setText(result[1]);
        deadlineInputDate.setText(result[2].split(" ")[0]);
        deadlineInputTime.setText(result[2].split(" ")[1]);
        editType.setSelection(((ArrayAdapter)editType.getAdapter()).getPosition(result[3]));
        remindonInputDate.setText(result[4].split(" ")[0]);
        remindonInputTime.setText(result[4].split(" ")[1]);
    }

    public void buttonOnSave(View v){
        Button save=(Button)v;
        //((Button) v).setText("Stop");0
        startActivity(new Intent(getApplication(),MyActivity.class));
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