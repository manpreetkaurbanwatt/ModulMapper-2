package com.example.modulmapper;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class modules extends AppCompatActivity {

    String pathway;
    String admin;
    DatabaseHelper db;
    ArrayList<Module> modules = new ArrayList<>();
    int year;
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private fragmentyear1 frag1;
    private fragmentyear2 frag2;
    private fragmentyear3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        frag1 = new fragmentyear1();
        frag2 = new fragmentyear2();
        frag3 = new fragmentyear3();

        tabLayout = (TabLayout)findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout)findViewById(R.id.appbarid);
        viewPager = (ViewPager)findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //adding fragments
        adapter.AddFragment(frag1, "Year 1");
        adapter.AddFragment(frag2, "Year 2");
        adapter.AddFragment(frag3, "Year 3");


        //adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        db = new DatabaseHelper(this);
        Bundle data = getIntent().getExtras();
        if(data==null){
            return;
        }

        admin = data.getString("admin");
        pathway = data.getString("pathway");
        year = data.getInt("year");
        //Toast.makeText(this, pathway, Toast.LENGTH_SHORT).show();
        //addModules(pathway);

        Bundle bundle = new Bundle();
        bundle.putString("pathway", pathway);
        frag1.setArguments(bundle);
        frag2.setArguments(bundle);
        frag3.setArguments(bundle);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    /*public void addModules(String pathway) {

        if (pathway.equals("network")) {
            modules = db.getModule("networkCourses");
        } else if (pathway == "database") {
            modules = db.getModule("databaseCourses");
        } else if (pathway == "web") {
            modules = db.getModule("webCourses");
        } else *//*(pathway == "software")*//* {
            modules = db.getModule("softwareCourses");
        }

        Module mod1 = modules.get(0);
        Module mod2 = modules.get(1);
        Module mod3 = modules.get(2);
        Module mod4 = modules.get(3);
        Module mod5 = modules.get(4);
        Module mod6 = modules.get(5);
        Module mod7 = modules.get(6);
        Module mod8 = modules.get(7);
        Module mod9 = modules.get(8);
        Module mod10 = modules.get(9);
        Module mod11 = modules.get(10);
        Module mod12 = modules.get(11);
        Module mod13 = modules.get(12);
        Module mod14 = modules.get(13);
        Module mod15 = modules.get(14);
        Module mod16 = modules.get(15);
        Module mod17 = modules.get(16);
        Module mod18 = modules.get(17);
        Module mod19 = modules.get(18);
        Module mod20 = modules.get(19);
        Module mod21 = modules.get(20);
        Module mod22 = modules.get(21);
        Module mod23 = modules.get(22);

        TextView title1 = findViewById(R.id.title1);
        title1.setText(mod1.get_moduleTitle());
        TextView title2 = findViewById(R.id.title2);
        title2.setText(mod2.get_moduleTitle());
        TextView title3 = findViewById(R.id.title3);
        title3.setText(mod3.get_moduleTitle());
        TextView title4 = findViewById(R.id.title4);
        title4.setText(mod4.get_moduleTitle());
        TextView title5 = findViewById(R.id.title5);
        title5.setText(mod5.get_moduleTitle());
        TextView title6 = findViewById(R.id.title6);
        title6.setText(mod6.get_moduleTitle());
        TextView title7 = findViewById(R.id.title7);
        title7.setText(mod7.get_moduleTitle());
        TextView title8 = findViewById(R.id.title8);
        title8.setText(mod8.get_moduleTitle());
        TextView title9 = findViewById(R.id.title9);
        title9.setText(mod9.get_moduleTitle());
        TextView title10 = findViewById(R.id.title10);
        title10.setText(mod10.get_moduleTitle());
        TextView title11 = findViewById(R.id.title11);
        title11.setText(mod11.get_moduleTitle());
        TextView title12 = findViewById(R.id.title12);
        title12.setText(mod12.get_moduleTitle());
        TextView title13 = findViewById(R.id.title13);
        title13.setText(mod13.get_moduleTitle());
        TextView title14 = findViewById(R.id.title14);
        title14.setText(mod14.get_moduleTitle());
        TextView title15 = findViewById(R.id.title15);
        title15.setText(mod15.get_moduleTitle());
        TextView title16 = findViewById(R.id.title16);
        title16.setText(mod16.get_moduleTitle());
        TextView title17 = findViewById(R.id.title17);
        title17.setText(mod17.get_moduleTitle());
        TextView title18 = findViewById(R.id.title18);
        title18.setText(mod18.get_moduleTitle());
        TextView title19 = findViewById(R.id.title19);
        title19.setText(mod19.get_moduleTitle());
        TextView title20 = findViewById(R.id.title20);
        title20.setText(mod20.get_moduleTitle());
        TextView title21 = findViewById(R.id.title21);
        title21.setText(mod21.get_moduleTitle());
        TextView title22 = findViewById(R.id.title22);
        title22.setText(mod22.get_moduleTitle());
        TextView title23 = findViewById(R.id.title23);
        title23.setText(mod23.get_moduleTitle());

        TextView code1 = findViewById(R.id.code1);
        code1.setText(mod1.get_moduleCode());
        TextView code2 = findViewById(R.id.code2);
        code2.setText(mod2.get_moduleCode());
        TextView code3 = findViewById(R.id.code3);
        code3.setText(mod3.get_moduleCode());
        TextView code4 = findViewById(R.id.code4);
        code4.setText(mod4.get_moduleCode());
        TextView code5 = findViewById(R.id.code5);
        code5.setText(mod5.get_moduleCode());
        TextView code6 = findViewById(R.id.code6);
        code6.setText(mod6.get_moduleCode());
        TextView code7 = findViewById(R.id.code7);
        code7.setText(mod7.get_moduleCode());
        TextView code8 = findViewById(R.id.code8);
        code8.setText(mod8.get_moduleCode());
        TextView code9 = findViewById(R.id.code9);
        code9.setText(mod9.get_moduleCode());
        TextView code10 = findViewById(R.id.code10);
        code10.setText(mod10.get_moduleCode());
        TextView code11 = findViewById(R.id.code11);
        code11.setText(mod11.get_moduleCode());
        TextView code12 = findViewById(R.id.code12);
        code12.setText(mod12.get_moduleCode());
        TextView code13 = findViewById(R.id.code13);
        code13.setText(mod13.get_moduleCode());
        TextView code14 = findViewById(R.id.code14);
        code14.setText(mod14.get_moduleCode());
        TextView code15 = findViewById(R.id.code15);
        code15.setText(mod15.get_moduleCode());
        TextView code16 = findViewById(R.id.code16);
        code16.setText(mod16.get_moduleCode());
        TextView code17 = findViewById(R.id.code17);
        code17.setText(mod17.get_moduleCode());
        TextView code18 = findViewById(R.id.code18);
        code18.setText(mod18.get_moduleCode());
        TextView code19 = findViewById(R.id.code19);
        code19.setText(mod19.get_moduleCode());
        TextView code20 = findViewById(R.id.code20);
        code20.setText(mod20.get_moduleCode());
        TextView code21 = findViewById(R.id.code21);
        code21.setText(mod21.get_moduleCode());
        TextView code22 = findViewById(R.id.code22);
        code22.setText(mod22.get_moduleCode());
        TextView code23 = findViewById(R.id.code23);
        code23.setText(mod23.get_moduleCode());
    }*/
}
