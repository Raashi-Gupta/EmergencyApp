package com.project.emergencyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Registration extends AppCompatActivity {
    Button hosp_reg,amb_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        hosp_reg=findViewById(R.id.hos_reg);
        amb_reg=findViewById(R.id.amb_reg);

        amb_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ambulance_register_fragment amb_frag=new Ambulance_register_fragment();
                loadFragment(amb_frag);
            }
        });
        hosp_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hospital_register_fragment hos_frag=new Hospital_register_fragment();
                loadFragment(hos_frag);
            }
        });
    }


    private void loadFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}