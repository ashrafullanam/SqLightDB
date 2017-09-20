package com.example.ashraf.sqlightdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Trainer on 9/10/2017.
 */

public class StudedentDataManager {
    public StudentDataBaseHelper studentDataBaseHelper;
    private Context context;
    public SQLiteDatabase sqLiteDatabase;

    public StudedentDataManager(Context context) {
        this.context=context;
        studentDataBaseHelper=new StudentDataBaseHelper(context);
    }

    public long addStudent(Student student){
        open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(StudentDataBaseHelper.COLUMN_NAME,student.getName());
        contentValues.put(StudentDataBaseHelper.COLUMN_PHONE,student.getPhoneNumber());

        long insertedRow=sqLiteDatabase.insert(StudentDataBaseHelper.TABLE_STUDENTS1,null,contentValues);

        sqLiteDatabase.close();
        return insertedRow;
    }

    public boolean update(Student student,int id){
        open();

        ContentValues contentValues=new ContentValues();
        contentValues.put(StudentDataBaseHelper.COLUMN_NAME,student.getName());
        contentValues.put(StudentDataBaseHelper.COLUMN_PHONE,student.getPhoneNumber());

        int updated=sqLiteDatabase.update(StudentDataBaseHelper.TABLE_STUDENTS1,contentValues,"id="+id,null);
        sqLiteDatabase.close();

        if(updated>0){
            return true;
        }else{
            return false;
        }

    }

    public long deleteItem(int id){
        open();
       long deleted1= sqLiteDatabase.delete(StudentDataBaseHelper.TABLE_STUDENTS1,"id="+id,null);

        sqLiteDatabase.close();

        if(deleted1<1){
            return 0;
        }else{
            return deleted1;
        }

    }

    public ArrayList<Student>getAllStudent(){
        int id;
        String name,phone;
        ArrayList<Student>students=new ArrayList<>();
        open();
        String selectQuery="select * from "+StudentDataBaseHelper.TABLE_STUDENTS1;


        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{

                id=cursor.getInt(cursor.getColumnIndex(StudentDataBaseHelper.COLUMN_ID));
                name=cursor.getString(cursor.getColumnIndex(StudentDataBaseHelper.COLUMN_NAME));
                phone=cursor.getString(cursor.getColumnIndex(StudentDataBaseHelper.COLUMN_PHONE));
                Student student=new Student(id,name,phone);
              students.add(student);
            }while(cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return students;
    }

    private void open() {
        sqLiteDatabase=studentDataBaseHelper.getWritableDatabase();
    }

}
