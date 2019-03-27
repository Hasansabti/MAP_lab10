package com.hzelectronics.lab10;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewCourses extends AppCompatActivity {
ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_courses);
        listview = findViewById(R.id.listview);
        DatabaseOpenHelper dbh = new DatabaseOpenHelper(this);
        SQLiteDatabase db = dbh.getWritableDatabase();

        Cursor cursor = db.rawQuery("select c_name from courses",null);
        ArrayList<String> al = new ArrayList<>();

        if(cursor != null){
            cursor.moveToFirst();
            do{
                String name = cursor.getString(0);
                al.add(name);

            }while (cursor.moveToNext());

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,al);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String name = listview.getItemAtPosition(position).toString();
                    Intent intent = new Intent(getApplicationContext(),EditCourses.class);
              intent.putExtra("CNAME",name);
                    startActivity(intent);

                }
            });

        }



    }
}
