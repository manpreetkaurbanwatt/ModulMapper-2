package com.example.modulmapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

public class dashboard extends AppCompatActivity {

    ImageView logosplash;
    Animation frombottom;

     GridLayout grid1;
    LinearLayout menuitems;
    String admin;
    String pathway;
    Button title1, title2, title3, title4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        title1 = (Button) findViewById(R.id.title1);
        title2 = (Button) findViewById(R.id.title2);
        title3 = (Button) findViewById(R.id.title3);
        title4 = (Button) findViewById(R.id.title4);

        Bundle data = getIntent().getExtras();
        if(data==null){
            return;
        }

        admin = data.getString("admin");

        title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathway = "database";
                Intent i = new Intent(dashboard.this, modules.class);
                i.putExtra("pathway", pathway);
                i.putExtra("admin", admin);
                i.putExtra("year", 1);
                startActivity(i);
            }
        });
        title2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathway = "networking";
                Intent i = new Intent(dashboard.this, modules.class);
                i.putExtra("pathway", pathway);
                i.putExtra("admin", admin);
                i.putExtra("year", 1);
                startActivity(i);
            }
        });
        title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathway = "software";
                Intent i = new Intent(dashboard.this, modules.class);
                i.putExtra("pathway", pathway);
                i.putExtra("admin", admin);
                i.putExtra("year", 1);
                startActivity(i);
            }
        });
        title4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pathway = "web";
                Intent i = new Intent(dashboard.this, modules.class);
                i.putExtra("pathway", pathway);
                i.putExtra("admin", admin);
                i.putExtra("year", 1);
                startActivity(i);
            }
        });

        /*logosplash = (ImageView)findViewById(R.id.logosplash);
        menuitems = (LinearLayout)findViewById(R.id.menuitems);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        logosplash.animate().translationY(-650).setDuration(800).setStartDelay(600);
        menuitems.startAnimation(frombottom);*/
    }



    public void setOnClickListener(View v) {

        switch (v.getId()){
            case(R.id.title1) :
                pathway = "database";
                break;
            case(R.id.title2)    :
                pathway = "network";
                break;
            case(R.id.title3)  :
                pathway = "software";
                break;
            case(R.id.title4)   :
                pathway = "web";
                break;
        }

        Intent i = new Intent(dashboard.this, modules.class);
        i.putExtra("pathway", pathway);
        i.putExtra("admin", admin);
        i.putExtra("year", 1);
        startActivity(i);
    }
}
