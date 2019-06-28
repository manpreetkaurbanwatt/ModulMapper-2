package com.example.modulmapper.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.modulmapper.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabaseHelper extends SQLiteOpenHelper {

    private StudentDatabaseHelper DBHelper;
    private SQLiteDatabase db;
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "StudentManager.db";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_FAVORITE_TABLE = "CREATE TABLE " + StudentContract.StudentEntry.TABLE_NAME + " (" +
                "id integer primary key autoincrement, " +
                StudentContract.StudentEntry._ID + " INTEGER NOT NULL," +
                StudentContract.StudentEntry.COLUMN_STUDENT_NAME + " TEXT NOT NULL, " +
                StudentContract.StudentEntry.COLUMN_STUDENT_EMAIL + " TEXT NOT NULL, " +
                StudentContract.StudentEntry.COLUMN_STUDENT_MAJOR + " TEXT NOT NULL, " +
                StudentContract.StudentEntry.COLUMN_STUDENT_PHONE + " TEXT NOT NULL " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_FAVORITE_TABLE);
    }
    //drop addstudent table
    private String DROP_ADDSTUDENT_TABLE = "DROP TABLE IF EXISTS " + StudentContract.StudentEntry.TABLE_NAME;

    public StudentDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //---opens the database---
    public StudentDatabaseHelper open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db1, int oldVersion, int newVersion) {

        //Drop User Table if exist

        db1.execSQL(DROP_ADDSTUDENT_TABLE);

        // Create tables again
        onCreate(db1);

    }
    //Method to create student records

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(StudentContract.StudentEntry._ID, student.getID());
        values.put(StudentContract.StudentEntry.COLUMN_STUDENT_NAME, student.getName());
        values.put(StudentContract.StudentEntry.COLUMN_STUDENT_EMAIL, student.getEmail());
        values.put(StudentContract.StudentEntry.COLUMN_STUDENT_MAJOR, student.getMajor());
        values.put(StudentContract.StudentEntry.COLUMN_STUDENT_PHONE, student.getPhone());

        db.insert(StudentContract.StudentEntry.TABLE_NAME, null, values);
        db.close();
    }
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                StudentContract.StudentEntry._ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = StudentContract.StudentEntry.COLUMN_STUDENT_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(StudentContract.StudentEntry.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
    public List<Student> getAllStudents() {
        // array of columns to fetch
        String[] columns = {
                StudentContract.StudentEntry._ID,
                StudentContract.StudentEntry.COLUMN_STUDENT_NAME,
                StudentContract.StudentEntry.COLUMN_STUDENT_EMAIL,
                StudentContract.StudentEntry.COLUMN_STUDENT_MAJOR,
                StudentContract.StudentEntry.COLUMN_STUDENT_PHONE
        };
        // sorting orders
        String sortOrder =
                StudentContract.StudentEntry.COLUMN_STUDENT_NAME + " ASC";
        List<Student> studentList = new ArrayList<Student>();

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(StudentContract.StudentEntry.TABLE_NAME, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setID(Integer.parseInt(cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry._ID))));
                student.setName(cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry.COLUMN_STUDENT_NAME)));
                student.setEmail(cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry.COLUMN_STUDENT_EMAIL)));
                student.setMajor(cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry.COLUMN_STUDENT_MAJOR)));
                student.setPhone(cursor.getString(cursor.getColumnIndex(StudentContract.StudentEntry.COLUMN_STUDENT_PHONE)));
                // Adding user record to list
                studentList.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return studentList;
    }


}

