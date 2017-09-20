package com.example.ashraf.sqlightdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StudentEntryActivity extends AppCompatActivity {
    EditText nameEt;
    EditText phoneEt,addressEt,professionEt;
    StudedentDataManager studedentDataManager;
    Button btnSave;
    private String name,phone;
    int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_entry);
        nameEt= (EditText) findViewById(R.id.nameEt);
        phoneEt= (EditText) findViewById(R.id.phoneET);
        btnSave= (Button) findViewById(R.id.btnSave);
        name=getIntent().getStringExtra("name");
        phone=getIntent().getStringExtra("phone");

        id=getIntent().getIntExtra("id",0);



        if(id>0){
            btnSave.setText("Update");
            nameEt.setText(name);
            phoneEt.setText(phone);

        }
    }

    @Override
    public void onBackPressed() {

        this.finish();



    }
    public void save(View view) {

        if(id!=0){

            Student student=new Student(nameEt.getText().toString(),phoneEt.getText().toString());

            studedentDataManager=new StudedentDataManager(this);
            studedentDataManager.update(student,id);
            this.finish();
            //startActivity(new Intent(this,MainActivity.class));

        }else {

            Student student = new Student(nameEt.getText().toString(), phoneEt.getText().toString());
            studedentDataManager = new StudedentDataManager(this);
            long isInserted = studedentDataManager.addStudent(student);
            if (isInserted > 0) {
                //Toast.makeText(this, "Index " + isInserted, Toast.LENGTH_SHORT).show();
                this.finish();
                 //startActivity(new Intent(this, MainActivity.class));
            } else {
                //Toast.makeText(this, "Unable to save data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
