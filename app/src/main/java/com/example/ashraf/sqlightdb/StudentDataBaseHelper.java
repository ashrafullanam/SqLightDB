package com.example.ashraf.sqlightdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Trainer on 9/10/2017.
 */

public class StudentDataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="student_db";

    private static final int DATABASE_VERSION=2;

    public static final String TABLE_STUDENTS1="basic_info";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_PHONE="phone";




    private static String CREATE_TABLE_STUDENT_BASIC="create table "+TABLE_STUDENTS1+"("+COLUMN_ID+" integer primary key autoincrement," +COLUMN_NAME+
            " text,"+COLUMN_PHONE+" text);";


    public StudentDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_STUDENT_BASIC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase.execSQL("drop "+TABLE_STUDENTS1+" if exists");
       onCreate(sqLiteDatabase);
    }
}
