package com.example.modulmapper;

import java.util.ArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class fragmentyear2 extends Fragment {

    View view;
    ArrayList<Module> modules = new ArrayList<Module>();
    DatabaseHelper db;
    String pathway = "not here";
    private fragmentyear1 frag1;
    private fragmentyear2 frag2;
    private fragmentyear3 frag3;

    public fragmentyear2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_year2, container, false);

        db = new DatabaseHelper(getContext());
        Bundle data = getArguments();
        pathway = data.getString("pathway");

        Toast.makeText(getContext(), pathway, Toast.LENGTH_SHORT).show();

        frag1 = new fragmentyear1();
        frag2 = new fragmentyear2();
        frag3 = new fragmentyear3();

        Bundle bundle = new Bundle();
        bundle.putString("pathway", pathway);
        frag1.setArguments(bundle);
        frag2.setArguments(bundle);
        frag3.setArguments(bundle);

        //addModules(pathway);

        return view;
    }

    public void addModules(String pathway) {
        if (pathway.equals("software")) {
            //modules = db.getModule("softwareCourses", 2);
            createFields();
        } else if (pathway.equals("network")) {
            //modules = db.getModule("networkCourses", 2);
            createFields();
        } else if (pathway.equals("web")) {
            //modules = db.getModule("webCourses", 2);
            createFields();
        } else if (pathway.equals("database")) {
            //modules = db.getModule("databaseCourses", 2);
            createFields();
        }

    }

    public  void createFields() {
        Module mod1 = modules.get(0);
        Module mod2 = modules.get(1);
        Module mod3 = modules.get(2);
        Module mod4 = modules.get(3);
        Module mod5 = modules.get(4);
        Module mod6 = modules.get(5);
        Module mod7 = modules.get(6);
        Module mod8 = modules.get(7);

        TextView title1 = view.findViewById(R.id.title1);
        title1.setText(mod1.get_moduleTitle());
        TextView title2 = view.findViewById(R.id.title2);
        title2.setText(mod2.get_moduleTitle());
        TextView title3 = view.findViewById(R.id.title3);
        title3.setText(mod3.get_moduleTitle());
        TextView title4 = view.findViewById(R.id.title4);
        title4.setText(mod4.get_moduleTitle());
        TextView title5 = view.findViewById(R.id.title5);
        title5.setText(mod5.get_moduleTitle());
        TextView title6 = view.findViewById(R.id.title6);
        title6.setText(mod6.get_moduleTitle());
        TextView title7 = view.findViewById(R.id.title7);
        title7.setText(mod7.get_moduleTitle());
        TextView title8 = view.findViewById(R.id.title8);
        title8.setText(mod8.get_moduleTitle());

        TextView code1 = view.findViewById(R.id.code1);
        code1.setText(mod1.get_moduleCode());
        TextView code2 = view.findViewById(R.id.code2);
        code2.setText(mod2.get_moduleCode());
        TextView code3 = view.findViewById(R.id.code3);
        code3.setText(mod3.get_moduleCode());
        TextView code4 = view.findViewById(R.id.code4);
        code4.setText(mod4.get_moduleCode());
        TextView code5 = view.findViewById(R.id.code5);
        code5.setText(mod5.get_moduleCode());
        TextView code6 = view.findViewById(R.id.code6);
        code6.setText(mod6.get_moduleCode());
        TextView code7 = view.findViewById(R.id.code7);
        code7.setText(mod7.get_moduleCode());
        TextView code8 = view.findViewById(R.id.code8);
        code8.setText(mod8.get_moduleCode());

    }

}
