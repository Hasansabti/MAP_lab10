package com.hzelectronics.lab10;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
EditText courseName, courseCode;
Spinner day;
TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courseName = findViewById(R.id.editText);
        courseCode = findViewById(R.id.editText2);
        day = findViewById(R.id.spinner);
        timePicker = findViewById(R.id.timePicker);



    }

    public void addCourse(View v){

String cName courseName.getText().toString();

String cCode = courseCode.getText().toString();
String selectedday = day.getSelectedItem().toString();
int hour = timePicker.getHour();
int minutes = timePicker.getMinute();
DatabaseOpenHelper dbh = new DatabaseOpenHelper(this);

        ContentValues

    }
}
