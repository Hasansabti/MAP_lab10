package com.hzelectronics.lab10;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
        courseName = findViewById(R.id.cnedit);
        courseCode = findViewById(R.id.ccedit);
        day = findViewById(R.id.spinneredit);
        timePicker = findViewById(R.id.timePicker);



        String[] arraySpinner = new String[] {
                "1", "2", "3", "4", "5", "6", "7"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day.setAdapter(adapter);



    }

    public void addCourse(View v){

String cName = courseName.getText().toString();

String cCode = courseCode.getText().toString();
String selectedday = day.getSelectedItem().toString();
int hour = timePicker.getHour();
int minutes = timePicker.getMinute();
DatabaseOpenHelper dbh = new DatabaseOpenHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("c_name",cName);
        values.put("c_code",cCode);
        values.put("day",selectedday);
        values.put("hour",hour);
        values.put("minute",minutes);
        db.insert("courses",null,values);
        dbh.close();





    }

    public void viewCourse(View v){
        Intent intent = new Intent(getApplicationContext(),ViewCourses.class);

        startActivity(intent);

    }
}
