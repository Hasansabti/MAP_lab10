package com.hzelectronics.lab10;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class EditCourses extends AppCompatActivity {
String code,day,cname;
int hour, minutes;

EditText cnEdit, CCEdit;
Spinner dayspinner;
TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_courses);

        cnEdit = findViewById(R.id.cnedit);
        CCEdit = findViewById(R.id.ccedit);
        dayspinner = findViewById(R.id.spinneredit);
        tp = findViewById(R.id.timePickeredit);

        cname = getIntent().getStringExtra("CNAME");

        DatabaseOpenHelper dbh = new DatabaseOpenHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        Cursor cursor = db.rawQuery("select c_name from courses where c_code = ?",new String[]{cname});

if(cursor != null){
    cursor.moveToFirst();
    do{
        code = cursor.getString(0);
        day = cursor.getString(2);
        hour = cursor.getInt(3);
        minutes = cursor.getInt(4);
    }while (cursor.moveToNext());
    cnEdit.setText(cname);
    CCEdit.setText(code);
    dayspinner.setSelection(setSpinnerValue(day));
}

    }
    public void updateCourse(View v){
        DatabaseOpenHelper dbh = new DatabaseOpenHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("c_name",cnEdit.getText().toString());
        values.put("c_code",CCEdit.getText().toString());
        values.put("day",day);
        values.put("hour",hour);
        values.put("minute",minutes);
        db.update("courses",values,"c_name = ?",new String[]{cname});
        Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
        dbh.close();

    }


    public void deleteCourse(View v){
        DatabaseOpenHelper dbh = new DatabaseOpenHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();
        db.delete("courses","c_name = ?",new String[]{cname});
        Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
        dbh.close();

    }
    public int setSpinnerValue(String day) {

        int position = 0;
        for (int i = 0; i < dayspinner.getCount(); i++) {
            if (dayspinner.getItemAtPosition(i).equals(day)) {
                position = i;
                break;
            }

        }
        return position;
    }
}
