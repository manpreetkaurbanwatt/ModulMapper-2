package com.example.modulmapper;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class fragmentyear1 extends Fragment {

    View view;
    int year = 1;
    ArrayList<Module> modules = new ArrayList<Module>();
    DatabaseHelper db;
    String pathway = "not here";
    private fragmentyear1 frag1;
    private fragmentyear2 frag2;
    private fragmentyear3 frag3;

    public fragmentyear1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_year1, container, false);
        db = new DatabaseHelper(getContext());
        Bundle data = getArguments();
        pathway = data.getString("pathway");

        frag1 = new fragmentyear1();
        frag2 = new fragmentyear2();
        frag3 = new fragmentyear3();

        Toast.makeText(getContext(), pathway, Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString("pathway", pathway);
        frag1.setArguments(bundle);
        frag2.setArguments(bundle);
        frag3.setArguments(bundle);
        bundle.putString("pathway", pathway);

        /*FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();*/

        addModules();

        return view;
    }

    public void addModules() {
        //modules = db.getModule("networkCourses");
    }
}
