package com.example.modulmapper;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.modulmapper.adapter.StudentRecyclerAdapter;
import com.example.modulmapper.model.Student;
import com.example.modulmapper.sql.StudentDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class student_list extends AppCompatActivity {
    private AppCompatActivity activity = student_list.this;
    Context context = student_list.this;
    private RecyclerView recyclerViewStudent;
    private ArrayList<Student> listStudent;
    private StudentRecyclerAdapter studentRecyclerAdapter;
    private StudentDatabaseHelper studentdatabaseHelper;
    SearchView searchBox;
    private ArrayList<Student> filteredList;
    String pathway = "software";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViews();
        initObjects();

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("Name")) {

            //get all needed extras intent

            List<Student> students = studentdatabaseHelper.getAllStudents();

            for (int x = 0; x < students.size(); x++) {
                Student student = students.get(x);
                int id = student.getID();
                String name = student.getName();
                String email = student.getEmail();
                String major = student.getMajor();
                String phone = student.getPhone();
            }
            /*int id = getIntent().getExtras().getInt("ID");
            String name = getIntent().getExtras().getString("Name");
            String email = getIntent().getExtras().getString("Email");
            String major = getIntent().getExtras().getString("Major");
            String phone = getIntent().getExtras().getString("Phone");*/



        }else{

            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();

        }

    }



    /**
     * This method is to initialize views
     */
    private void initViews() {
        recyclerViewStudent = (RecyclerView) findViewById(R.id.recyclerViewStudent);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listStudent = new ArrayList<>();
        studentRecyclerAdapter = new StudentRecyclerAdapter(listStudent, this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewStudent.setLayoutManager(mLayoutManager);
        recyclerViewStudent.setItemAnimator(new DefaultItemAnimator());
        recyclerViewStudent.setHasFixedSize(true);
        recyclerViewStudent.setAdapter(studentRecyclerAdapter);
        studentdatabaseHelper = new StudentDatabaseHelper(activity);

        getDataFromSQLite();

    }





    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listStudent.clear();
                listStudent.addAll(studentdatabaseHelper. getAllStudents());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                studentRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
