package com.example.ashraf.sqlightdb;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    StudedentDataManager studedentDataManager;
    ArrayList<Student>students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.studentsList);
        studedentDataManager=new StudedentDataManager(this);
        students=studedentDataManager.getAllStudent();
        ArrayAdapter<Student>studentArrayAdapter=new ArrayAdapter<Student>(this,android.R.layout.simple_list_item_1,students);
        listView.setAdapter(studentArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i=new Intent(MainActivity.this,DetailsActivity.class);
                i.putExtra("id",students.get(position).getId());
                startActivity(i);
            }
        });
    }

    public void moveToStudentEntryPage(View view) {
        Intent intent=new Intent(this,StudentEntryActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Dialog");
        builder.setMessage("Are sure to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}