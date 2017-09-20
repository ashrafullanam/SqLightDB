package com.example.ashraf.sqlightdb;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private TextView nameTv,phoneTv,addressTv,professionTv;
    int id=0;
    String name,phone,address,profession;
    private StudentDataBaseHelper studentDataBaseHelper;

    private SQLiteDatabase sqLiteDatabase;
    private StudedentDataManager studedentDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameTv= (TextView) findViewById(R.id.nameTv);
        phoneTv= (TextView) findViewById(R.id.phoneTv);

        studentDataBaseHelper=new StudentDataBaseHelper(this);
        studedentDataManager=new StudedentDataManager(this);

        id=getIntent().getIntExtra("id",0);


       // Toast.makeText(this, id+"", Toast.LENGTH_SHORT).show();


        getData(id);


    }

    public void getData(int id){
        if(id==0){
            return;
        }
        //Toast.makeText(this, "I am here with "+id, Toast.LENGTH_SHORT).show();
        sqLiteDatabase=studentDataBaseHelper.getReadableDatabase();

        Cursor mCursor = sqLiteDatabase.rawQuery("SELECT * FROM "+StudentDataBaseHelper.TABLE_STUDENTS1+" WHERE "+id+" = "+StudentDataBaseHelper.COLUMN_ID,null);

           mCursor.moveToFirst();

                name=mCursor.getString(mCursor.getColumnIndex(StudentDataBaseHelper.COLUMN_NAME));
                phone=mCursor.getString(mCursor.getColumnIndex(StudentDataBaseHelper.COLUMN_PHONE));


        sqLiteDatabase.close();

        nameTv.setText(name);
        phoneTv.setText(phone);
    }

    public void onUpdate(View view) {
        Intent i=new Intent(new Intent(this,StudentEntryActivity.class));
        i.putExtra("name",name);
        i.putExtra("id",id);
        i.putExtra("phone",phone);
        this.finish();
        startActivity(i);
    }

    public void onDelete(View view) {
       /* long value= studedentDataManager.deleteItem(id);


        if(value<1){

        }else{
            Toast.makeText(this, value+" row is deleted", Toast.LENGTH_SHORT).show();

        }
        startActivity(new Intent(this,MainActivity.class));*/

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Dialog");
        builder.setMessage("Are sure to Delete?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                long value= studedentDataManager.deleteItem(id);


                if(value<1){

                }else{
                    Toast.makeText(DetailsActivity.this, value+" row is deleted", Toast.LENGTH_SHORT).show();

                }
                DetailsActivity.this.finish();
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
