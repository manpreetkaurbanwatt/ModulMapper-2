package com.example.modulmapper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClientDashboard extends AppCompatActivity implements View.OnClickListener{

    EditText student_search, student_name, student_id, student_email, student_major;
    SQLiteDatabase sqlitedb;
    Button add, delete, update, Search, searchall;
    String studentsearch, name, studentid, studentemail, major, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_dashboard);

        //create database
        sqlitedb = openOrCreateDatabase("WIntecClient", Context.MODE_PRIVATE, null);
        //create table StudentDetails
        sqlitedb.execSQL("Create table if not EXISTS StudentDetails(id integer primary key autoincrement, studentName varchar(255), studentID varchar(255), studentEmail varchar(255), studentMajor varchar(255));");

        student_search = (EditText) findViewById(R.id.student_search);
        student_name = (EditText) findViewById(R.id.student_name);
        student_id = (EditText) findViewById(R.id.student_id);
        student_email = (EditText) findViewById(R.id.student_email);
        student_major = (EditText) findViewById(R.id.student_major);
        add = (Button) findViewById(R.id.btnsave);
        delete = (Button) findViewById(R.id.btndel);
        update = (Button) findViewById(R.id.btnupdate);
        Search = (Button) findViewById(R.id.btnsearch);
        searchall = (Button) findViewById(R.id.btnsearchall);

        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        update.setOnClickListener(this);
        Search.setOnClickListener(this);
        searchall.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnsave){
            name = student_name.getText().toString().trim();
            studentid = student_id.getText().toString().trim();
            studentemail = student_email.getText().toString().trim();
            major = student_major.getText().toString().trim();

            if(name.equals("") || studentid.equals("") || studentemail.equals("") || major.equals("")){
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }else{
                sqlitedb.execSQL("Insert into StudentDetails(studentName, studentID, studentEmail, studentMajor)VALUES('"+name+"','"+studentid+"','"+studentemail+"','"+student_major+"');");
                Toast.makeText(this, "Record Saved", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.getId() == R.id.btnsearchall){
            Cursor c = sqlitedb.rawQuery("Select * from StudentDetails", null);
            if(c.getCount()==0){
                Toast.makeText(this, "Database Empty", Toast.LENGTH_SHORT).show();
                return;
            }

            //display the result into string buffer
            StringBuffer buffer = new StringBuffer();
            while(c.moveToNext())
            {
                buffer.append("Student Id:" +c.getString(1)+"\n");
                buffer.append("Student Name:" +c.getString(2)+"\n");
                buffer.append("Student Email:" +c.getString(3)+"\n");
                buffer.append("Student Major:" +c.getString(4)+"\n");
            }
            //display all data in Toast
            Toast.makeText(this, buffer.toString(), Toast.LENGTH_LONG).show();
        }
        else if(view.getId() == R.id. btnsearch){
            search = student_search.getText().toString().trim();
            if(search.equals(""))
            {
                Toast.makeText(this, "Enter Student Name", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c = sqlitedb.rawQuery("Select * from StudentDetails where studentName = '"+ search+"'", null);
            if(c.moveToFirst())
            {
                student_name.setText(c.getString(1));
                student_id.setText(c.getString(2));
                student_email.setText(c.getString(3));
                student_major.setText(c.getString(4));
            }else{
                Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.getId() == R.id.btnupdate){
            search = student_search.getText().toString().trim();
            studentid = student_id.getText().toString().trim();
            name = student_name.getText().toString().trim();
            studentemail = student_email.getText().toString().trim();
            major = student_major.getText().toString().trim();
            if(search.equals(""))
            {
                Toast.makeText(this, "Please enter student nameto update", Toast.LENGTH_SHORT).show();
                return;
            }

            Cursor cursorUpdate =  sqlitedb.rawQuery("Select * from StudentDetails WHERE StudentName = '"+search+"'", null);
            if(cursorUpdate.moveToFirst())
            {
                if(name.equals("") || studentid.equals("") || studentemail.equals("") || major.equals(""))
                {
                    Toast.makeText(this, "Field cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                     sqlitedb.execSQL("Update StudentDetails SET studentName = '"+name+"', studentID = '"+studentid+"',studentEmail = '"+studentemail+"',studentMajor = '"+major+"' WHERE studentName = '"+search+"'");
                    Toast.makeText(this, "Record Modified", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.getId() == R.id.btndel){
            search = student_search.getText().toString().trim();
            if(search.equals(""))
            {
                Toast.makeText(this, "nter Student Name to Delete", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor cursorDelete = sqlitedb.rawQuery("Select * from StudentDetails WHERE StudentName = '"+search+"'", null);
            if(cursorDelete.moveToFirst())
            {
                sqlitedb.execSQL("Delete From StudentDetails WHERE StudentName = '"+search+"'");
                Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
