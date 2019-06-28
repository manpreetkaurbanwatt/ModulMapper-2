package com.example.modulmapper;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import androidx.cardview.widget.CardView;

public class fragmentyear1 extends Fragment implements View.OnClickListener {

    View view;
    int year = 1;
    ArrayList<Module> modules = new ArrayList<Module>();
    DatabaseHelper db;
    String pathway = null;
    private fragmentyear1 frag1;
    private fragmentyear2 frag2;
    private fragmentyear3 frag3;
    CardView card1;
    CardView card2;
    CardView card3;
    CardView card4;
    CardView card5;
    CardView card6;
    CardView card7;
    CardView card8;

    Module mod1 = null;
    Module mod2 = null;
    Module mod3;
    Module mod4;
    Module mod5;
    Module mod6;
    Module mod7;
    Module mod8;

    String code = null;
    String title = null;
    String description = null;
    int credits = 0;

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
        /*frag2 = new fragmentyear2();
        frag3 = new fragmentyear3();*/

        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card4 = view.findViewById(R.id.card4);
        card5 = view.findViewById(R.id.card5);
        card6 = view.findViewById(R.id.card6);
        card7 = view.findViewById(R.id.card7);
        card8 = view.findViewById(R.id.card8);

        //Toast.makeText(getContext(), p, Toast.LENGTH_SHORT).show();

        /*Bundle bundle = new Bundle();
        bundle.putString("pathway", pathway);
        frag1.setArguments(bundle);
        frag2.setArguments(bundle);
        frag3.setArguments(bundle);
        bundle.putString("pathway", pathway);*/

        /*FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();*/

        addModules();

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.card1:
                title = mod1.get_moduleTitle();
                code = mod1.get_moduleCode();
                description = mod1.get_prescription();
                credits = mod1.get_credits();
                Toast.makeText(getContext(), code, Toast.LENGTH_SHORT).show();
                moduleDiscription();
                break;
            case R.id.card2:
                title = mod2.get_moduleTitle();
                code = mod2.get_moduleCode();
                description = mod2.get_prescription();
                credits = mod2.get_credits();
                moduleDiscription();
                break;
            case R.id.card3:
                title = mod3.get_moduleTitle();
                code = mod3.get_moduleCode();
                description = mod3.get_prescription();
                credits = mod3.get_credits();
                moduleDiscription();
                break;
            case R.id.card4:
                title = mod4.get_moduleTitle();
                code = mod4.get_moduleCode();
                description = mod4.get_prescription();
                credits = mod4.get_credits();
                moduleDiscription();
                break;
            case R.id.card5:
                title = mod5.get_moduleTitle();
                code = mod5.get_moduleCode();
                description = mod5.get_prescription();
                credits = mod5.get_credits();
                moduleDiscription();
                break;
            case R.id.card6:
                title = mod6.get_moduleTitle();
                code = mod6.get_moduleCode();
                description = mod6.get_prescription();
                credits = mod6.get_credits();
                moduleDiscription();
                break;
            case R.id.card7:
                title = mod7.get_moduleTitle();
                code = mod7.get_moduleCode();
                description = mod7.get_prescription();
                credits = mod7.get_credits();
                moduleDiscription();
                break;
            case R.id.card8:
                title = mod8.get_moduleTitle();
                code = mod8.get_moduleCode();
                description = mod8.get_prescription();
                credits = mod8.get_credits();
                moduleDiscription();
                break;

            default:
                throw new RuntimeException("Unknow button ID");
        }

    }

    public void addModules() {
        modules = db.getModule("networkCourses", 1);
        createFields();
    }

    public void createFields() {
        mod1 = modules.get(0);
        mod2 = modules.get(1);
        mod3 = modules.get(2);
        mod4 = modules.get(3);
        mod5 = modules.get(4);
        mod6 = modules.get(5);
        mod7 = modules.get(6);
        mod8 = modules.get(7);

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

    // dialog shows if correct
    public void moduleDiscription() {
        final Dialog moduleDescription = new Dialog(getContext());
        moduleDescription.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (moduleDescription.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            moduleDescription.getWindow().setBackgroundDrawable(colorDrawable);
        }
        moduleDescription.setContentView(R.layout.module_description);
        moduleDescription.setCancelable(false);
        moduleDescription.show();

        TextView txtCode = moduleDescription.findViewById(R.id.txtCode);
        TextView txtTitle = moduleDescription.findViewById(R.id.txtTitle);
        TextView txtDescription = moduleDescription.findViewById(R.id.txtDescription);
        TextView txtCredits = moduleDescription.findViewById(R.id.txtCredits);
        View view4 = moduleDescription.findViewById(R.id.view4);
        txtCode.setText(code);
        txtTitle.setText(title);
        txtDescription.setText(description);
        txtCredits.setText("Credits: " + String.valueOf(credits));

        ImageView btnEscape = (ImageView) moduleDescription.findViewById(R.id.btnEscape);

        btnEscape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dismiss the dialog
                moduleDescription.dismiss();


                //resetColor();
                //Enable buttons
                //enableButton();
            }
        });

        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dismiss the dialog
                moduleDescription.dismiss();
            }

        });

    }

}