package com.example.modulmapper.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.modulmapper.R;
import com.example.modulmapper.model.Student;

import java.util.ArrayList;

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>  {
    private ArrayList<Student> listStudent;
    public ImageView overflow;
    private Context mContext;
    private ArrayList<Student> mFilteredList;


    public StudentRecyclerAdapter(ArrayList<Student> listStudent, Context mContext) {
        this.listStudent = listStudent;
        this.mContext = mContext;
        this.mFilteredList = listStudent;


    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewMajor;
        public AppCompatTextView textViewPhone;
        public  ImageView overflow;

        public StudentViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewMajor = (AppCompatTextView) view.findViewById(R.id.textViewMajor);
            textViewPhone = (AppCompatTextView) view.findViewById(R.id.textViewPhone);

        }
    }
    @Override
    public StudentRecyclerAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_recycler, parent, false);

        return new StudentViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(final StudentViewHolder holder, int position) {
        holder.textViewName.setText(listStudent.get(position).getName());
        holder.textViewEmail.setText(listStudent.get(position).getEmail());
        holder.textViewMajor.setText(listStudent.get(position).getMajor());
        holder.textViewPhone.setText(listStudent.get(position).getPhone());


    }


    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }



}